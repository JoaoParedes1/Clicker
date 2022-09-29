package com.joaoparedes.clicker.models;

public class Upgrade {
    private String nome;
    private String desc;
    private int efeito;
    private boolean click;
    private int custo;
    private int version;

    public Upgrade(String nome, int version, String desc, int efeito, boolean click, int custo) {
        this.nome = nome;
        this.version = version;
        this.desc = desc;
        this.efeito = efeito;
        this.click = click;
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public String getDesc() {
        return desc;
    }

    public int getEfeito() {
        return efeito;
    }

    public boolean isClick() {
        return click;
    }

    public int getCusto() {
        return custo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}