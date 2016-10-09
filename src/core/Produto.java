package core;

public class Produto {
    private String id;
    private String nome;

    public Produto(String nome) {
        this.nome = nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String obtemId() {
        return id;
    }

    public String obtemNome() {
        return nome;
    }
}
