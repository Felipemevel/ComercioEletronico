package main.java.model;

import java.time.LocalDateTime;

public class Venda {

    private int id;
    private LocalDateTime date;
    private double total;
    private boolean carrinho;
    private int idCLiente;

    public Venda(){}
    public Venda(int id, LocalDateTime date, double total, boolean carrinho, int idCLiente){
        this.id = id;
        this.date = date;
        this.total = total;
        this.carrinho = carrinho;
        this.idCLiente = idCLiente;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setDate(LocalDateTime date){
        this.date = date;
    }
    public LocalDateTime getDate(){
        return date;
    }
    public void setTotal(double total){
        this.total = total;
    }
    public double getTotal(){
        return total;
    }
    public void setCarrinho(boolean carrinho){
        this.carrinho = carrinho;
    }
    public boolean getCarrinho(){
        return carrinho;
    }
    public void setIdCLiente(int idCLiente){
        this.idCLiente = idCLiente;
    }
    public int getIdCLiente(){
        return idCLiente;
    }

    @Override
    public String toString() {
        return "| ID: " + id +
                " - Data: " + date +
                " - Total: " + total +
                " - Carrinho: " + carrinho +
                " - ID do Cliente" + idCLiente;
    }
}
