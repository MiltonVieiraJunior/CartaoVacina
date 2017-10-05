package com.neri.alexa.cartaovacina.Model;

/**
 * Created by alexa on 19/09/2017.
 */

public class Vacina {
    private String idade;
    private String nome;
    private String doenca_protecao;
    private String dose;
    private String qtd;
    private String via_adm;

    public Vacina( String nome, String idade, String dose, String qtd) {
        this.nome = nome;
        this.idade= idade;
        this.dose=dose;
        this. qtd= qtd;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDoenca_protecao(String doenca_protecao) {
        this.doenca_protecao = doenca_protecao;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setQtd(String qtd) {
        this.qtd = qtd;
    }

    public void setVia_adm(String via_adm) {
        this.via_adm = via_adm;
    }

    public String getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getDoenca_protecao() {
        return doenca_protecao;
    }

    public String getDose() {
        return dose;
    }

    public String getQtd() {
        return qtd;
    }

    public String getVia_adm() {
        return via_adm;
    }
}
