package app;

import java.util.Scanner;

public class Data{
    private byte dia;
    private byte mes;
    private short ano;

    Data(int dia, int mes, int ano){
        this.dia = (byte)dia;
        this.mes = (byte)mes;
        this.ano = (short)ano;
    }

    public byte getDia() {
        return dia;
    }

    public byte getMes() {
        return mes;
    }

    public short getAno() {
        return ano;
    }

    @Override
    public String toString() {
        String dia = "";
        String mes = "";

        if (this.dia < 10){
            dia += ("0" + this.dia);
        } else {
            dia += this.dia;
        }
        if (this.mes < 10){
            mes += ("0" + this.mes);
        } else {
            mes += this.mes;
        }
        return dia + "/" + mes + "/" + this.ano;
    }

    
    
    
}