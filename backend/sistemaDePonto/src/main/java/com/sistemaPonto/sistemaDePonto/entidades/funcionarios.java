package com.sistemaPonto.sistemaDePonto.entidades;

public class funcionarios {
    private String nome;
    private String cargo;

    public void setNome(String input){
        this.nome=input;

    };
    public void setCargo(String input){
        this.cargo=input;
    };

    public String getNome(){
        return this.nome;
    };
    public String getCargo(){
        return this.cargo;
    };
}
