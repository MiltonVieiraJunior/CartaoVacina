package com.neri.alexa.cartaovacina.Model;

/**
 * Created by alexa on 17/09/2017.
 */

public class Usuario {

    private int id;
    private Vacina vacina;
    private byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Vacina getVacina() {




        return vacina;
    }

    public void setVacina(Vacina v) {
        this.vacina=  v;

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nome;
    private String email;
    private String data;

    public Usuario() {
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

