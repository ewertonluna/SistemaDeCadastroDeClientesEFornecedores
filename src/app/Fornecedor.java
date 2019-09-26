package app;

public class Fornecedor{
    private String cnpj; 
    private String nome;
    private String nomeFantasia; 
    private String email;
    private Data dataDeFundacao;
    private Endereco endereco;
    private String tipoDeServico;

    Fornecedor(String cnpj, String nome, String nomeFantasia,
               String email, Data dataDeFundacao, Endereco endereco, String tipoDeServico){

            this.cnpj = cnpj;
            this.nome = nome;
            this.nomeFantasia = nomeFantasia;
            this.email = email;
            this.dataDeFundacao = dataDeFundacao;
            this.endereco = endereco;
            this.tipoDeServico = tipoDeServico;
    }

    // Construtor sem inicializar propriedade nomeFantasia
    Fornecedor(String cnpj, String nome, String email,
               Data dataDeFundacao, Endereco endereco, String tipoDeServico){
        
        this(cnpj, nome, null, email, dataDeFundacao, endereco, tipoDeServico);
    }

    /**
     * Compara dois objetos Fornecedor pelo cnpj.
     * @param fornecedor    Objeto Fornecedor
     * @return  boolean     true se cnpj forem iguais, false caso contrário
     */
    public boolean equals(Fornecedor fornecedor){
        return this.cnpj.equals(fornecedor.cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getEmail() {
        return email;
    }

    public Data getDataDeFundacao() {
        return dataDeFundacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTipoDeServico() {
        return tipoDeServico;
    }

    @Override
    public String toString() {
        return "Fornecedor [cnpj=" + cnpj + ", dataDeFundacao=" + dataDeFundacao + ", email=" + email + ", endereco="
                + endereco + ", nome=" + nome + ", nomeFantasia=" + nomeFantasia + ", tipoDeServico=" + tipoDeServico
                + "]";
    }

    
    
    


}