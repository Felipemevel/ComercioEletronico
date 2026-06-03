package ui;

import dao.CategoriaDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import model.Cliente;
import model.Produto;
import util.Util;

import java.util.Scanner;

public class UI {

    private static Scanner sc = new Scanner(System.in);

    private static ProdutoDAO produtoDAO = new ProdutoDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static CategoriaDAO categoriaDAO = new CategoriaDAO();

    public static void main(String[] args) {
        int option;
        do {
            option = menuPrincipal();
            switch (option){
                case 1 -> menuClientes();
                case 2 -> menuProdutos();
                case 3 -> menuCategorias();
                case 4 -> System.out.println(">>> Saindo do sistema... :)");
                default -> System.out.println(">>> Opção Inválida!");
            }
        } while (option != 4);
    }

    public static int menuPrincipal(){
        System.out.println("========================================");
        System.out.println("=            MENU PRINCIPAL            =");
        System.out.println("========================================");
        System.out.println("= 1 - Clientes                         =");
        System.out.println("= 2 - Produtos                         =");
        System.out.println("= 3 - Categorias                       =");
        System.out.println("= 4 - Sair                             =");
        System.out.println("========================================");

        return Util.convInt(sc, "> Digite a opção: ");
    }

    public static void menuClientes(){
        int option;
        do {
            System.out.println("========================================");
            System.out.println("=              CLIENTES                =");
            System.out.println("========================================");
            System.out.println("= 1 - Inserir novo cliente             =");
            System.out.println("= 2 - Listar todos os clientes         =");
            System.out.println("= 3 - Atualizar cliente                =");
            System.out.println("= 4 - Remover cliente                  =");
            System.out.println("= 5 - Voltar                           =");
            System.out.println("========================================");

            option = Util.convInt(sc, "> Digite a opção: ");

            switch (option){
                case 1 -> inserirCliente();
                case 2 -> listarClientes();
                case 3 -> atualizarCliente();
                case 4 -> removeCliente();
                case 5 -> System.out.println(">>> Voltando ao menu principal...");
                default -> System.out.println(">>> Opção inválida!");
            }
        } while (option != 5);
    }

    public static void menuProdutos(){
        int option;
        do {
            System.out.println("========================================");
            System.out.println("=              PRODUTOS                =");
            System.out.println("========================================");
            System.out.println("= 1 - Inserir novo produto             =");
            System.out.println("= 2 - Listar todos os produtos         =");
            System.out.println("= 3 - Atualizar produto                =");
            System.out.println("= 4 - Remover produto                  =");
            System.out.println("= 5 - Voltar                           =");
            System.out.println("========================================");

            option = Util.convInt(sc, "> Digite a opção: ");

            switch (option){
                case 1 -> System.out.println("Em construção...");
                case 2 -> System.out.println("Em construção...");
                case 3 -> System.out.println("Em construção...");
                case 4 -> System.out.println("Em construção...");
                case 5 -> System.out.println(">>> Voltando ao menu principal...");
                default -> System.out.println(">>> Opção inválida!");
            }
        } while (option != 5);
    }

    public static void menuCategorias(){
        int option;
        do {
            System.out.println("========================================");
            System.out.println("=              CATEGORIAS              =");
            System.out.println("========================================");
            System.out.println("= 1 - Inserir nova categoria           =");
            System.out.println("= 2 - Listar todas as categorias       =");
            System.out.println("= 3 - Atualizar categoria              =");
            System.out.println("= 4 - Remover categoria                =");
            System.out.println("= 5 - Voltar                           =");
            System.out.println("========================================");

            option = Util.convInt(sc, "> Digite a opção: ");

            switch (option){
                case 1 -> System.out.println("Em construção...");
                case 2 -> System.out.println("Em construção...");
                case 3 -> System.out.println("Em construção...");
                case 4 -> System.out.println("Em construção...");
                case 5 -> System.out.println(">>> Voltando ao menu principal...");
                default -> System.out.println(">>> Opção inválida!");
            }
        } while (option != 5);
    }

    /**
     *  MÉTODOS CLIENTE
     */
    public static void inserirCliente(){
        String nome = Util.lerTexto(sc, "> Insira o nome do cliente");
        String fone = Util.lerTexto(sc, "> Insira o telefone do cliente");
        String email = Util.lerTexto(sc, "> Insira o e-mail do cliente");

        Cliente novoCliente = new Cliente(0, nome, email, fone);
        clienteDAO.inserir(novoCliente);

        System.out.println(">>> Cliente cadastrado com sucesso!");
    }

    public static void listarClientes(){
        System.out.println("\n=== LISTA DE CLIENTES ===");

        var lista = clienteDAO.listar();
        if (lista.isEmpty()){
            System.out.println("Nenhum cliente cadastrado no sistema.");
            return;
        }
        System.out.println("\n=== LISTA DE CLIENTES ===");
        for (Cliente c : lista){
            System.out.println("= " + c);
            System.out.println("-----------------------------------");
        }

    }

    public static void atualizarCliente(){
        System.out.println("\n=== INSERIR NOVO CLIENTE ===");

        int id = Util.convInt(sc, "> Insira o ID do cliente que deseja atualizar os dados: ");
        Cliente clienteDesejado = clienteDAO.listarId(id);

        if (clienteDesejado == null){
            System.out.println(">>> Erro: Cliente com ID " + id + " não encontrado.");
            return;
        }
        System.out.println("\nDados atuais do cliente:");
        System.out.println(clienteDesejado);
        System.out.println("-----------------------------------");

        String nome = Util.lerTexto(sc, "> Insira o novo nome: ");
        String fone = Util.lerTexto(sc, "> Insira o novo telefone: ");
        String email = Util.lerTexto(sc, "> Insira o novo e-mail: ");

        Cliente clienteAtualizado = new Cliente(id, nome, fone, email);
        clienteDAO.atualizar(clienteAtualizado);
    }

    public static void removeCliente(){
        System.out.println("\n=== REMOVER CLIENTE ===");

        int id = Util.convInt(sc, "> Insira o ID do cliente que deseja remover: ");
        Cliente clienteDesejado = clienteDAO.listarId(id);

        if (clienteDesejado == null){
            System.out.println(">>> Erro: Cliente com ID " + id + " não encontrado.");
            return;
        }
        System.out.println("\nDados do cliente:");
        System.out.println(clienteDesejado);
        System.out.println("-----------------------------------");

        clienteDAO.excluir(clienteDesejado);
    }

    /**
     *  MÉTODOS PRODUTOS
     */

    public static void inserirProduto(){
        String descricao = Util.lerTexto(sc, ">>> Insira a descrição do produto: ");
        double preco = Util.convDouble(sc, ">>> Insira o preço do produto: ");
        int estoque = Util.convInt(sc, ">>> Insira a quantidade de produtos no estoque: ");

        Produto novoProduto = new Produto(0, descricao, preco, estoque);
        produtoDAO.inserir(novoProduto);

        System.out.println(">>> Produto cadastrado com sucesso!");
    }
}
