package com.sistemaPonto.sistemaDePonto.respositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionarios;

public class respositorioFuncionario {
    public void insert(Funcionarios funcionario) throws SQLException{
        String sql = "insert into funcionarios (nome, cargo) " + "values(?,?)";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setString(1, funcionario.getNome());
            pstm.setString(2, funcionario.getCargo());
            pstm.execute();
        }    
    }

    public List<Funcionarios> funcionarios() throws SQLException{
        
        List<Funcionarios> funcionarios=new ArrayList<Funcionarios>();
        

        String sql = "select * from funcionarios";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Funcionarios funcionario=new Funcionarios();

                String nome = query.getString("nome");
                String cargo = query.getString("cargo");
                int id = query.getInt("id");

                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);

                funcionarios.add(funcionario);
            }
            return funcionarios;
        }
    }

}
