package com.sistemaPonto.sistemaDePonto.respositorios;

import java.sql.SQLException;
import java.util.List;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionario;
import com.sistemaPonto.sistemaDePonto.entidades.Registro;

public class RepositorioRegistroFuncionario {

    private static RepositorioRegistroFuncionario myself = new RepositorioRegistroFuncionario();
    private RepositorioRegistro registro = null;
    private RespositorioFuncionario funcionario = null;



    public RepositorioRegistroFuncionario() {
        registro = new RepositorioRegistro();
        funcionario = new RespositorioFuncionario();
    }

    public static RepositorioRegistroFuncionario getMyInstance() {
        return myself;
    }

    /***********************************************
     * Metodos para inserção de dados
     **********************************************/
    public void insert(Funcionario funcionario) throws SQLException {
        this.funcionario.insert(funcionario);
    }

    public void insert(Registro registro) throws SQLException {
        this.registro.insert(registro);
    }

    
    /***********************************************
     * Metodos para leitura de informações
     ************************************************/
    
    public List<Funcionario> read() throws SQLException {
        return this.funcionario.GetFuncionariosList();
    }

    public List<Registro> read(int key) throws SQLException {
        return this.registro.GetResgistrosList(key);
    }

}
