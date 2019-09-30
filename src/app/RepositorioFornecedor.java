package app;

public class RepositorioFornecedor{
    private Fornecedor[] fornecedores = new Fornecedor[100];
    private static RepositorioFornecedor instancia;

    private RepositorioFornecedor(){}

    public static RepositorioFornecedor getInstancia(){
        if (instancia == null){
            instancia = new RepositorioFornecedor();
        }

        return instancia;
    }

    /**
     * Verifica se existe fornecedor dentro do array fornecedores.
     * @param fornecedorProcurado   Objeto Fornecedor
     * @return  int posição do array do fornecedor encontrado. Caso 
     *          nenhum fornecedor seja encontrado, retorna -1.
     */
    private int existeFornecedor(Fornecedor fornecedorProcurado){
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] != null && this.fornecedores[i].equals(fornecedorProcurado)){
                return i;
            }
        }

        return -1;
    }

    /**
     * Procura posição disponível no array fornecedores.
     * @return  int i posição do array, caso exista posição disponível,
     *          caso contrário, retorna -1
     */
    private int vagaDisponivel(){
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] == null){
                return i;
            }
        }
        
        return -1;
    }

    /**
     * Insere fornecedor numa posição disponível dentro do array
     * @param fornecedor    Objeto Fornecedor
     * @return  boolean true se havia vaga e objeto foi inserido. false, caso contrário
     */
    public boolean inserirFornecedor(Fornecedor fornecedor){
        int indexFornecedorExistente = this.existeFornecedor(fornecedor);
        int indexVagaDisponivel = this.vagaDisponivel();

        if (indexFornecedorExistente < 0 && indexVagaDisponivel >= 0) {
            this.fornecedores[indexVagaDisponivel] = fornecedor;
            return true;
        }

        return false;
    }

    /**
     * Remove fornecedor por cnpj
     * @param cnpj  String cnpj do fornecedor a ser removido
     * @return  true se existe fornecedor com o cnpj e ele foi removido, false caso contrário
     */
    public boolean removerFornecedorPorCNPJ(String cnpj){
        for (int i = 0; i < this.fornecedores.length; i++) {
            Fornecedor fornecedor = this.fornecedores[i];

            if (fornecedor != null && fornecedor.getCnpj().equals(cnpj)){
                this.fornecedores[i] = null;
                return true;
            }
        }
        
        return false;
    }

    /**
     * Pesquisa por fornecedores com o tipo de servico requerido e retorna todos os fornecedores
     * encontrados num array
     * @param tipoDeServico String tipo de serviço 
     * @return  Fornecedor[] array contendo fornecedores encontrados
     */
    public Fornecedor[] pesquisarFornecedorPorTipoDeServico(String tipoDeServico){
        int numeroDeFornecedoresEncontrados = 0;
        int aux = 0;

        for (int i = 0; i < this.fornecedores.length; i++) {
            Fornecedor fornecedor = this.fornecedores[i];

            if (fornecedor != null && fornecedor.getTipoDeServico().equals(tipoDeServico)){
                numeroDeFornecedoresEncontrados++;
            }
        }
        Fornecedor[] listaDeFornecedores = new Fornecedor[numeroDeFornecedoresEncontrados];

        for (int i = 0; i < this.fornecedores.length; i++) {
            Fornecedor fornecedor = this.fornecedores[i];

            if (fornecedor != null && fornecedor.getTipoDeServico().equals(tipoDeServico)){
                listaDeFornecedores[aux] = fornecedor;
                aux += 1;
            }
        }

        return listaDeFornecedores;
    }

    /**
     *  Pesquisa fornecedores por CEP e retorna fornecedores encontrados num array
     * @param cep   int CEP requerido
     * @return  Fornecedor[] array contendo os fornecedores encontrados
     */
    public Fornecedor[] pesquisarFornecedorPorCEP(int cep){
        int numeroDeFornecedoresEncontrados = 0;
        int aux = 0;

        for (int i = 0; i < this.fornecedores.length; i++) {
            Fornecedor fornecedor = this.fornecedores[i];
            
            if (fornecedor != null && fornecedor.getEndereco().getCep() == cep){
                numeroDeFornecedoresEncontrados += 1;
            }
        }

        Fornecedor[] listaDeFornecedores = new Fornecedor[numeroDeFornecedoresEncontrados];

        for (int i = 0; i < this.fornecedores.length; i++) {
            Fornecedor fornecedor = this.fornecedores[i];
            
            if (fornecedor != null && fornecedor.getEndereco().getCep() == cep){
                listaDeFornecedores[aux] = fornecedor;
                aux += 1;
            }
        }
        return listaDeFornecedores;
    }




}