package br.com.fiap.domain.entity;

public class TipoDeBem {

    private Long id;

    private String nome;

    public TipoDeBem() {
    }

    public TipoDeBem(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public TipoDeBem setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeBem setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        return "TipoDeBem{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
