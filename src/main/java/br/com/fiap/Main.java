package br.com.fiap;

import br.com.fiap.domain.entity.Bem;
import br.com.fiap.domain.entity.Departamento;
import br.com.fiap.domain.entity.Inventario;
import br.com.fiap.domain.entity.TipoDeBem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static EntityManagerFactory factory;
    private static EntityManager manager;

    public static void main(String[] args) {
        initializeEntityManager();
        try {
//            TipoDeBem tipoDeBem = addTipoBem();
//            System.out.println(tipoDeBem);
//
//            Departamento departamento = addDepartamento();
//            System.out.println(departamento);
//
//            Bem bem = addBem();
//            System.out.println(bem);
//
//            Inventario inventario = addInventario();
//            System.out.println(inventario);
//
//            listarTodosBens();

            Inventario inventarioBuscado = buscarInventarioPorId();
            System.out.println(inventarioBuscado);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }
    }

    private static void initializeEntityManager() {
        factory = Persistence.createEntityManagerFactory("oracle");
        manager = factory.createEntityManager();
    }

    private static void closeEntityManager() {
        manager.close();
        factory.close();
    }

    private static Inventario addInventario() {
        String relatorio = JOptionPane.showInputDialog("Relatório: ");
        LocalDate inicio = obterData("Data de início no formato DD/MM/AAAA");
        Departamento departamentoSelecionado = addDepartamento();

        Inventario inventario = new Inventario()
                .setRelatorio(relatorio)
                .setInicio(inicio)
                .setDepartamento(departamentoSelecionado);

        salvarObjeto(inventario);

        return inventario;
    }

    private static Bem addBem() {
        String nome = JOptionPane.showInputDialog("Nome: ");
        String etiqueta = JOptionPane.showInputDialog("Etiqueta: ");
        TipoDeBem tipoBemSelecionado = addTipoBem();
        Departamento departamentoSelecionado = addDepartamento();
        LocalDate aquisicao = obterData("Data de aquisição no formato DD/MM/AAAA");

        Bem bem = new Bem()
                .setNome(nome)
                .setEtiqueta(etiqueta)
                .setAquisicao(aquisicao)
                .setTipo(tipoBemSelecionado)
                .setLocalizacao(departamentoSelecionado);

        salvarObjeto(bem);

        return bem;
    }

    // Métodos semelhantes para adicionar TipoDeBem e Departamento

    private static Departamento addDepartamento() {
        List<Departamento> departamentos = manager.createQuery("FROM Departamento").getResultList();
        return obterItemSelecionado("Selecione o departamento", departamentos);
    }

    private static TipoDeBem addTipoBem() {
        List<TipoDeBem> tiposDeBem = manager.createQuery("FROM TipoDeBem").getResultList();
        return obterItemSelecionado("Selecione o tipo de bem", tiposDeBem);
    }

    private static <T> T obterItemSelecionado(String mensagem, List<T> itens) {
        return (T) JOptionPane.showInputDialog(
                null, mensagem, "Selecione uma opção",
                JOptionPane.QUESTION_MESSAGE, null, itens.toArray(), itens.get(0)
        );
    }

    private static LocalDate obterData(String mensagem) {
        String dataStr = JOptionPane.showInputDialog(mensagem);
        int dia = Integer.parseInt(dataStr.substring(0, 2));
        int mes = Integer.parseInt(dataStr.substring(3, 5));
        int ano = Integer.parseInt(dataStr.substring(6, 10));
        return LocalDate.of(ano, mes, dia);
    }

    private static void salvarObjeto(Object objeto) {
        manager.getTransaction().begin();
        manager.persist(objeto);
        manager.getTransaction().commit();
    }

    private static void listarTodosBens() {
        List<Bem> bens = manager.createQuery("FROM Bem").getResultList();
        for (Bem bem : bens) {
            System.out.println(bem);
        }
    }

    private static Inventario buscarInventarioPorId() {
        Long id = Long.parseLong(JOptionPane.showInputDialog("Digite o id do inventário que deseja buscar: "));
        return manager.find(Inventario.class, id);
    }
}
