package main.java.model;

public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private int estoque;
    private int idCategoria;

    public Produto(){}
    public Produto(int id, String descricao, double preco, int estoque) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "| ID: " + id +
                " - Descrição: " + descricao +
                " - Preço: " + preco +
                " - Estoque: " + estoque +
                " - ID da Categoria:" + idCategoria;
    }
}
