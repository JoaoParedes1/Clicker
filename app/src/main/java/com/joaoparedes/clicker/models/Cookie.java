package com.joaoparedes.clicker.models;

public class Cookie {
    private int numeroCookies = 0;
    private int click = 1;
    private int cps = 0;


    private static Cookie instance;

    public static Cookie getInstance(){
        if(instance == null){
            instance = new Cookie();
        }
        return instance;
    }

    public void cookieClick(){
        numeroCookies += click;
    }

    public void cookieSegundo(){
        numeroCookies += cps;
    }

    public int getNumeroCookies() {
        return numeroCookies;
    }

    public void setNumeroCookies(int numeroCookies) {
        this.numeroCookies = numeroCookies;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public int getCps() {
        return cps;
    }

    public void setCps(int cps) {
        this.cps = cps;
    }
}
