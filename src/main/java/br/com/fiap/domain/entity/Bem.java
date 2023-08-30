package br.com.fiap.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Bem {

    private Long id;

    private String nome;

    private TipoDeBem tipo;

    private String etiqueta;

    private Departamento localizacao;

    private LocalDate aquisicao;


    public Bem() {
    }

    public Bem(Long id, String nome, TipoDeBem tipo, String etiqueta, Departamento localizacao, LocalDate aquisicao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
        this.localizacao = localizacao;
        this.aquisicao = aquisicao;
    }

    public Long getId() {
        return id;
    }

    public Bem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Bem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public TipoDeBem getTipo() {
        return tipo;
    }

    public Bem setTipo(TipoDeBem tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public Bem setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
        return this;
    }

    public Departamento getLocalizacao() {
        return localizacao;
    }

    public Bem setLocalizacao(Departamento localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public Bem setAquisicao(LocalDate aquisicao) {
        this.aquisicao = aquisicao;
        return this;
    }

    @Override
    public String toString() {
        return "Bem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", etiqueta='" + etiqueta + '\'' +
                ", localizacao=" + localizacao +
                ", aquisicao=" + aquisicao +
                '}';
    }
}
