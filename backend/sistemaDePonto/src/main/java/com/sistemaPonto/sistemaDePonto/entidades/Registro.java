package com.sistemaPonto.sistemaDePonto.entidades;

public class Registro {
    private String hora;
    private String data;
    private int id_funcionario;

    public void setIdFuncionario(int id_funcionario){
        this.id_funcionario=id_funcionario;
    };
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
    public int getIdFuncionario(){
        return this.id_funcionario;
    };
}
