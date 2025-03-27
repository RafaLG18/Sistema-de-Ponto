package com.sistemaPonto.sistemaDePonto.entidades;

public class Funcionarios {
    private String nome;
    private String cargo;
    private int id;

    public void setId(int id){
        this.id=id;
    }
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
    public int getId(){
        return this.id;
    }
}
