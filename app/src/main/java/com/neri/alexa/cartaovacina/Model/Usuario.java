package com.neri.alexa.cartaovacina.Model;

/**
 * Created by alexa on 17/09/2017.
 */

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String data;

    public Usuario() {
    }

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getData() {
        return data;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setData(String data) {
        this.data = data;
    }
}

