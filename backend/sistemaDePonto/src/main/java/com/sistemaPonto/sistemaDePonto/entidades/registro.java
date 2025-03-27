package com.sistemaPonto.sistemaDePonto.entidades;

public class registro {
    private String hora;
    private String data;

    public void setHora(String input){
        this.hora=input;
    };
    public void setData(String input){
        this.data=input;
    };

    public String getHora(){
        return this.hora;
    };
    public String getData(){
        return this.data;
    };
}
