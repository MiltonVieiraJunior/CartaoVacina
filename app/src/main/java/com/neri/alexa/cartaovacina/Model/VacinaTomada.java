package com.neri.alexa.cartaovacina.Model;

/**
 * Created by alexa on 06/10/2017.
 */

public class VacinaTomada {

    private String nome;
    private int Id;

    public VacinaTomada() {

    }
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
