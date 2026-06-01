package ui;

import dao.CategoriaDAO;
import dao.ClienteDAO;
import dao.ProdutoDAO;

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

        System.out.print("> Digite a opção: ");
        return sc.nextInt();
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

            System.out.print("> Digite a opção: ");
            option = sc.nextInt();

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

            System.out.print("> Digite a opção: ");
            option = sc.nextInt();

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

            System.out.print("> Digite a opção: ");
            option = sc.nextInt();

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
}
