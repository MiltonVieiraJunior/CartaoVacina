package com.neri.alexa.cartaovacina.Model;

/**
 * Created by alexa on 19/09/2017.
 */

public class Hospital {
    private  String nome;
    private  String endereço;
    private  String bairro;
    private  String fone;

    public Hospital(String nome, String endereço, String bairro, String fone) {
        this.nome = nome;
        this.endereço = endereço;
        this.bairro = bairro;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
