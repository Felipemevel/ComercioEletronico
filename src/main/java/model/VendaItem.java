package main.java.model;

public class VendaItem {

    private int id;
    private int idVenda;
    private int idProduto;
    private int quantidade;
    private double preco;

    public VendaItem(){}
    public VendaItem(int id, int quantidade, double preco) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public String toString() {
        return "| ID: " + id +
                " - ID Venda: " + idVenda +
                " - ID Produto: " + idProduto +
                " - Quantidade: " + quantidade +
                " - Preço" + preco;
    }
}
