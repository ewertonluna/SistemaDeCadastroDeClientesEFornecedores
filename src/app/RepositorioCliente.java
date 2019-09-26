package app;

public class RepositorioCliente{
    private Cliente[] clientes = new Cliente[100];
    private static RepositorioCliente instancia = new RepositorioCliente();
    
    private RepositorioCliente() {}

    public static RepositorioCliente getInstancia(){
        if (instancia == null){
           instancia = new RepositorioCliente(); 
        }

        return instancia;
    }

    /**
     * Retorna array de clientes.
     * @return  campo Cliente[] clientes
     */
    public Cliente[] getClientes() {
        return clientes;
    }

    /**
     * Procura por cliente com o mesmo cpf dentro do array de clientes.
     * @param clienteProcurado  Objeto Cliente a ser encontrado
     * @return  Se há match, int index do match. -1 caso contrário                   
     */
    public int existeCliente(Cliente clienteProcurado){
        for (int index = 0; index < this.clientes.length; index++){
            
            if (this.clientes[index] != null && this.clientes[index].equals(clienteProcurado)){
                return index;
            }
        }
        return -1;
    }

    /**
     * Verifica se existe disponibilidade no array clientes.
     * @return  int index da posição disponível, -1 caso contrário.
     */
    public int existeVaga(){
        for (int index = 0; index < this.clientes.length; index++){
            if (this.clientes[index] == null){
                return index;
            }
        }
        return -1;
    }

    /**
     * Insere cliente numa posição disponível dentro do array de clientes.
     * @param cliente   Objeto Cliente a ser inserido
     * @return  boolean true se cliente foi inserido, false caso contrário
     */
    public boolean inserirCliente(Cliente cliente){
        int indexCliente = this.existeCliente(cliente);
        int indexVagaDisponivel = this.existeVaga();
        
        if (indexCliente < 0){
            if (indexVagaDisponivel >= 0){
                this.clientes[indexVagaDisponivel] = cliente;
                return true;
            }

        }
        return false;
    }

    /**
     * Remove cliente pelo código
     * @param codigoProcurado    int codigo do cliente a ser removido.
     * @return boolean  true se algum cliente foi removido, false caso contrário
     */
    public boolean removerClientePorCodigo(int codigoProcurado){
        for (int i = 0; i < this.clientes.length; i++){
            
            if (this.clientes[i] != null && this.clientes[i].getCodigo() == codigoProcurado){
                this.clientes[i] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Remove clientes por nome.
     * @param nomeProcurado  String nome do cliente a ser removido
     * @return  int numero de clientes removidos    
     */
    public int removerClientesPorNome(String nomeProcurado){
        int numeroDeClientesRemovidos = 0;
        
        for (int i = 0; i < this.clientes.length; i++){
            Cliente cliente = this.clientes[i];
            
            if (cliente != null && cliente.getNome().equals(nomeProcurado)){
                this.clientes[i] = null;
                numeroDeClientesRemovidos += 1;
            }
        }
        return numeroDeClientesRemovidos;
    }

    /**
     * Procura por objeto Cliente que contenha o mesmo código
     * @param codigoPesquisado    codigo do cliente a ser procurado
     * @return  Cliente caso cliente exista. Caso contrário, retorna null
     */
    public Cliente pesquisarClientePorCodigo(int codigoPesquisado){
        for (Cliente cliente : this.clientes){
            
            if (cliente != null && cliente.getCodigo() == codigoPesquisado){
                return cliente;
            }
        }
        return null;
    }

    /**
     * Pesquisar por todos os clientes que tem o mesmo bairro.
     * @param bairroPesquisado    String bairro pesquisado
     * @return  Cliente[] array que contém todos os clientes encontrados
     */
    public Cliente[] pesquisarClientesPorBairro(String bairroPesquisado){
        int numeroDeClientesEncontrados = 0;
        int aux = 0;

        for (Cliente cliente : this.clientes){
            if (cliente != null && cliente.getEndereco().getBairro().equals(bairroPesquisado)){
                numeroDeClientesEncontrados += 1;
            }
        }

        Cliente[] resultado = new Cliente[numeroDeClientesEncontrados];
        
        for (int i = 0; i < this.clientes.length; i++){
            if (this.clientes[i] != null){
                String bairro = this.clientes[i].getEndereco().getBairro();
                
                if (bairro.equals(bairroPesquisado)){
                    resultado[aux] = this.clientes[i];
                    aux += 1;
                }
            }
        }
        return resultado;
    }

    


    


  



}