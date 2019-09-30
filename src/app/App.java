package app;

import java.util.Scanner;

public class App {
    static RepositorioCliente repositorioCliente = RepositorioCliente.getInstancia();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        boolean ready = true;
        int opcaoEscolhida;

        while (ready){
            System.out.println("** Bem-vindo(a) ao sistema de cadastro **");
            System.out.println("Entre com a opção desejada:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastro de Clientes");
            System.out.println("2 - Cadastro de Fornecedores");
            System.out.print(">> ");

            opcaoEscolhida = scanner.nextInt();

            if (opcaoEscolhida == 0) {
                ready = false;
            } else if (opcaoEscolhida == 1){
                UICliente uicliente = new UICliente();
                uicliente.showMenu();
            } else if (opcaoEscolhida == 2){
                UIFornecedor uifornecedor = new UIFornecedor();
                uifornecedor.showMenu();
            }


        }
    }
}