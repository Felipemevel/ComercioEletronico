package util;

import java.util.Scanner;

public class Util {

    public static int convInt(Scanner sc, String msg){
        while (true){
            System.out.print(msg);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, digite apenas números.");
            }
        }
    }

    public static double convDouble(Scanner sc, String msg){
        while (true){
            System.out.print(msg);
            String input = sc.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e){
                System.out.println("Entrada inválida! Por favor, digite apenas números.");
            }
        }
    }

    public static String lerTexto(Scanner sc, String msg){
            while (true){
                System.out.print(msg);
                String input = sc.nextLine();

                if (!input.isEmpty()){
                    return input;
                }
                System.out.println("Erro: Este campo é obrigatório e não pode ficar em branco!");
            }
    }
}
