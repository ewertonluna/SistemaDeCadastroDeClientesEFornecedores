package app;

public class Endereco{
    private String rua;
    private String bairro;
    private short numero;
    private int cep;
    private String complemento;

    Endereco(String rua, String bairro, int numero, int cep, String complemento){
        this.rua = rua;
        this.bairro = bairro;
        this.numero = (byte)numero;
        this.cep = cep;
        this.complemento = complemento;
    }

    Endereco(String rua, String bairro, int numero, int cep){
        this(rua, bairro, numero, cep, null);
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public short getNumero() {
        return numero;
    }

    public int getCep(){
        return cep;
    }

    public String getComplemento(){
        return complemento;
    }

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + ", numero=" + numero
                + ", rua=" + rua + "]";
    }

    

    
}