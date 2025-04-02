package com.sistemaPonto.sistemaDePonto.respositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionario;
import com.sistemaPonto.sistemaDePonto.entidades.Registro;

public class RespositorioFuncionario {

    /*************************************************/
    /*
     * Metodos para manipulação dos dados de Funcionários
     */
    /*************************************************/

    // Retorna instancia do RepositorioFuncionario-> Acesso aos métodos sem instanciar essa classe em outras classes.
    
    // Insere dados de funcionário no banco
    public void insert(Funcionario funcionario) throws SQLException{
        String sql = "insert into funcionarios (nome, cargo) " + "values(?,?)";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCargo());
            pstm.execute();
        }    
    }
    // Preenche lista de funcionarios cadastrados a partir do banco
    public List<Funcionario> GetFuncionariosList() throws SQLException{
        
        List<Funcionario> funcionariosDB=new ArrayList<Funcionario>();
        String sql = "select * from funcionarios";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Funcionario funcionario=new Funcionario();

                String nome = query.getString("nome");
                String cargo = query.getString("cargo");
                int id = query.getInt("id");

                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);

                funcionariosDB.add(funcionario);
            }
            return funcionariosDB;
        }
    }
    
    /*************************************************/
    /*
     * Metodos para manipulação dos Repositório Registro
     */
    /**
     ************************************************/

}
