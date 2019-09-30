package app;

import java.util.Scanner;

public class UICliente{
    private static Scanner scanner = new Scanner(System.in);
    
    public void showMenu() {
        boolean ready = true;
        int opcaoEscolhida;

        while (ready){
            System.out.println("===== Cadastro de clientes =====");
            System.out.println("Escolha uma das opções:");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir cliente");
            System.out.println("2 - Remover cliente pelo código");
            System.out.println("3 - Remover cliente pelo nome");
            System.out.println("4 - Pesquisar cliente por código");
            System.out.println("5 - Pesquisar cliente por bairro");
            System.out.print(">> ");

            opcaoEscolhida = scanner.nextInt();
            scanner.nextLine();

            if (opcaoEscolhida == 0){
                ready = false;
            } else if (opcaoEscolhida == 1){
                inserirCliente();
            } else if (opcaoEscolhida == 2) {
                removerClientePorCodigo();
            } else if (opcaoEscolhida == 3){
                removerClientePorNome();
            } else if (opcaoEscolhida == 4){
                pesquisarClientePorCodigo();
            } else if (opcaoEscolhida == 5){
                pesquisarClientePorBairro();
            }
        }
    }

    private void inserirCliente(){
        // limpar a tela
        int codigo;
        String nome, email, cpf;
        Endereco endereco;
        Data dataDeNascimento;

        System.out.println("Entre com o código:");
        codigo = scanner.nextInt(); 
        scanner.nextLine();
        System.out.println("Entre com o nome:");
        nome = scanner.nextLine();
        System.out.println("Entre com o email:");
        email = scanner.nextLine();
        System.out.println("Entre com o cpf:");
        cpf = scanner.nextLine();

        endereco = criarEndereco();
        dataDeNascimento = criarData();

        Cliente cliente = new Cliente(codigo, nome, email, cpf, endereco, dataDeNascimento);
        boolean isInserido = RepositorioCliente.getInstancia().inserirCliente(cliente);

        if (isInserido){
            System.out.println("Cliente inserido com sucesso!");
        } else{
            System.out.println("Cliente não inserido");
        }
    }

    private void removerClientePorCodigo(){
        int codigo;
        boolean foiRemovido;

        System.out.println("Entre com o código do cliente a ser removido:");
        codigo = scanner.nextInt();

        foiRemovido = RepositorioCliente.getInstancia().removerClientePorCodigo(codigo);

        if (foiRemovido){
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Não há clientes com o código inserido");
        }
    }

    private void removerClientePorNome(){
        String nome;
        int quantidadeRemovida;

        System.out.println("Qual o nome do cliente a ser removido?");
        nome = scanner.nextLine();
        quantidadeRemovida = RepositorioCliente.getInstancia().removerClientesPorNome(nome);
        
        System.out.println(quantidadeRemovida + " cliente(s) removidos!");


    }

    private void pesquisarClientePorCodigo(){
        int codigo;
        Cliente clienteEncontrado;

        System.out.println("Entre com o código do cliente:");
        codigo = scanner.nextInt(); scanner.nextLine();
        clienteEncontrado = RepositorioCliente.getInstancia().pesquisarClientePorCodigo(codigo);

        if (clienteEncontrado != null){
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("Nenhum cliente encontrado");
        }
    }

    private void pesquisarClientePorBairro(){
        String bairro;
        Cliente[] clientesEncontrados;

        System.out.println("Entre com o bairro do(s) cliente(s)");
        bairro = scanner.nextLine();
        clientesEncontrados = RepositorioCliente.getInstancia().pesquisarClientesPorBairro(bairro);

        if (clientesEncontrados.length > 0){
            for (Cliente cliente : clientesEncontrados) {
                System.out.println(cliente);
            }
        } else {
            System.out.println("Nenhum cliente encontrado");
        }
    }

    private Endereco criarEndereco(){
        String rua, bairro, complemento;
        int numero, cep;

        System.out.println("Entre com a rua:");
        rua = scanner.nextLine();
        System.out.println("Entre com o bairro:");
        bairro = scanner.nextLine();
        System.out.println("Entre com o número:");
        numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entre com a CEP:");
        cep = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Entre com a complemento:");
        complemento = scanner.nextLine();

        return new Endereco(rua, bairro, numero, cep, complemento);
    }

    private Data criarData(){
        byte dia, mes;
        short ano;

        System.out.println("Entre com o dia:");
        dia = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Entre com o mês:");
        mes = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Entre com o ano:");
        ano = scanner.nextShort();
        scanner.nextLine();

        return new Data(dia, mes, ano);
    }



}