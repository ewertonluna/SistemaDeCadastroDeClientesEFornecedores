package app;

public class RepositorioProduto{
    private Produto[] produtos = new Produto[100];
    private static RepositorioProduto instancia;

    private RepositorioProduto(){}

    public static RepositorioProduto getInstancia(){
        if (instancia == null){
            instancia = new RepositorioProduto();
        }

        return instancia;
    }

    public Produto[] getProdutos(){
        return this.produtos;
    }

    /**
     * Verifica se existe produto e caso exista, retorna seu index. Caso contrário
     * retorna -1
     * @param produto   Objeto Produto
     * @return  Index do produto, caso exista. Caso contrário, retorna -1.
     */
    public int existeProduto(Produto produto){
        String nome = produto.getNome();
        String tipo = produto.getTipo();

        for (int i = 0; i < this.produtos.length; i++) {
            
            if (this.produtos[i] != null && this.produtos[i].getNome().equals(nome)){
                if (this.produtos[i].getTipo().equals(tipo)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Verifica se existe vaga em produtos e retorna o index da vada disponível caso exista.
     * @return  Index da vaga disponível, caso exista. Caso não exista, retorna -1. 
     */
    public int existeVaga(){
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null){
                return i;
            }
        }
        return -1;
    }


    public boolean cadastrarProduto(Produto produto){
        int indexDoProdutoExistente = this.existeProduto(produto);
        int indexDaVagaDisponivel = this.existeVaga();
        int quantidade = produto.getQuantidade();
        boolean adicionou = false;
        
        /* Se produto já é cadastrado e a quantidade a ser adicionada não ultrapassa 1000,
            será incrementada a quantidade do produto no cadastro */
        if (indexDoProdutoExistente >= 0){
            int quantidadeExistente = this.produtos[indexDoProdutoExistente].getQuantidade();

            if (quantidadeExistente + quantidade <= 1000){
                this.produtos[indexDoProdutoExistente].aumentarQuantidade(quantidade);
                adicionou = true;
            }
        
        /* Se o produto não é cadastrado e existe vaga disponível, o produto é cadastrado */
        } else{
            if (indexDaVagaDisponivel >= 0){
                this.produtos[indexDaVagaDisponivel] = produto;
                adicionou = true;
            }
        }

        
        return adicionou;
    }


}