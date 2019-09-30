package app;

import java.util.Scanner;

public class UIFornecedor{
    static private Scanner scanner = new Scanner(System.in);

    public void showMenu(){
        boolean ready = true;
        int opcaoEscolhida;

        while(ready){
            System.out.println("===== Cadastro de fornecedores =====");
            System.out.println("Escolha uma das opções:");
            System.out.println("0 - Sair");
            System.out.println("1 - Inserir fornecedor");
            System.out.println("2 - Remover fornecedor pelo CNPJ");
            System.out.println("3 - Pesquisar fornecedor pelo tipo de serviço prestado");
            System.out.println("4 - Pesquisar fornecedor pelo CEP");
            System.out.print(">> ");

            opcaoEscolhida = scanner.nextInt(); scanner.nextLine();

            if (opcaoEscolhida == 0){
                ready = false;
            } else if (opcaoEscolhida == 1){
                inserirFornecedor();
            } else if (opcaoEscolhida == 2){
                removerFornecedorPorCNPJ();
            } else if (opcaoEscolhida == 3){
                pesquisarFornecedorPorTipoDeServico();
            } else if (opcaoEscolhida == 4){
                // pesquisarFornecedorPorCEP();
            }
        }
        
    }

    private void inserirFornecedor(){
        String cnpj, nome, nomeFantasia, email;
        Data dataDeFundacao;
        Endereco endereco;
        String tipoDeServico;

        // Refatorar esse código criando um método em Cliente e 
        // em Fornecedor para criar cliente e fornecedor, assim como 
        // foi feito em Data.criarData()
        System.out.println("Entre com o CNPJ");
        cnpj = scanner.nextLine();
        System.out.println("Entre com o nome");
        nome = scanner.nextLine();
        System.out.println("Entre com o nome fantasia");
        nomeFantasia = scanner.nextLine();
        System.out.println("Entre com o email");
        email = scanner.nextLine();
        System.out.println("Entre com o tipo de serviço:");
        tipoDeServico = scanner.nextLine();
        
        dataDeFundacao = criarData();
        endereco = criarEndereco();

        Fornecedor fornecedor = new Fornecedor(cnpj, nome, nomeFantasia, email, dataDeFundacao, endereco, tipoDeServico);
        boolean isInserido = RepositorioFornecedor.getInstancia().inserirFornecedor(fornecedor);

        if (isInserido){
            System.out.println("Fornecedor inserido com sucesso!");
        } else{
            System.out.println("Fornecedor não inserido");
        }

        
    }

    private void removerFornecedorPorCNPJ(){
        String cnpj;
        boolean isRemovido;

        System.out.println("Entre com o CNPJ do fornecedor a ser removido");
        cnpj = scanner.nextLine();

        isRemovido = RepositorioFornecedor.getInstancia().removerFornecedorPorCNPJ(cnpj);

        if (isRemovido){
            System.out.println("Fornecedor removido com sucesso");
        } else{
            System.out.println("Não há fornecedor com esse CNPJ a ser removido");
        }
    }

    private void pesquisarFornecedorPorTipoDeServico(){
        String tipoDeServico;
        Fornecedor[] fornecedoresEncontrados;

        System.out.println("Entre com o tipo de serviço do fornecedor a ser removido:");
        tipoDeServico = scanner.nextLine();

        fornecedoresEncontrados = RepositorioFornecedor.getInstancia().pesquisarFornecedorPorTipoDeServico(tipoDeServico);

        if (fornecedoresEncontrados.length > 0){
            for (Fornecedor fornecedor : fornecedoresEncontrados){
                System.out.println(fornecedor);
            }
        } else {
            System.out.println("Nenhum fornecedor encontrado!");
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