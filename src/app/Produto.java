package app;

public class Produto{
    private String nome;
    private String tipo;
    private int quantidade;

    Produto(String nome, String tipo, int quantidade){
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    Produto(String nome, String tipo){
        this(nome, tipo, 0);
    }

    public boolean aumentarQuantidade(int quantidade){
        if (quantidade >= 0){
            this.quantidade += quantidade;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }




}