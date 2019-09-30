package app;

public class Cliente {
    private int codigo;
    private String nome, email, cpf;
    private Endereco endereco;
    private Data dataDeNascimento;
    
    Cliente(int codigo, String nome, String email, String cpf, Endereco endereco, Data dataDeNascimento){
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * Compara dois objetos clientes pelo campo cpf
     * @param cliente   Objeto cliente 
     * @return  boolean    true se clientes possuem mesmo cpf. false, caso contrario.                   
     */
    public boolean equals(Cliente cliente){
        return this.cpf.equals(cliente.cpf);
    }

    public String toString(Cliente cliente){
        return cliente.nome;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCPF(){
        return this.cpf;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public Data getDataDeNascimento(){
        return this.dataDeNascimento;
    }

    @Override
    public String toString() {
        return "Cliente [codigo=" + codigo + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento + ", email="
                + email + ", endereco=" + endereco + ", nome=" + nome + "]";
    }

    

    

}