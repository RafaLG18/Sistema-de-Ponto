package com.sistemaPonto.sistemaDePonto.respositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemaPonto.sistemaDePonto.entidades.Registro;

public class RepositorioRegistro {

    public void insert(Registro registro) throws SQLException{
        String sql = "insert into registro (id_funcionario,data_registro, hora_chegada) " + "values(?,?,?)";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setInt(1, registro.getIdFuncionario());
            pstm.setString(2, registro.getData());
            pstm.setString(3, registro.getHora());
            pstm.execute();
        }    
    }

    public List<Registro> GetResgistrosList(int id_funcionario)throws SQLException{
        List<Registro> registrosDB=new ArrayList<Registro>();
        String sql = "select data_registro,hora_chegada from registro where id_funcionario ="+"?";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setInt(1, id_funcionario);
            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Registro registro=new Registro();

                String data = query.getString("data_registro");
                String hora = query.getString("hora_chegada");
                
                registro.setData(data);
                registro.setHora(hora);
                registro.setIdFuncionario(id_funcionario);

                registrosDB.add(registro);
            }
            return registrosDB;
        }
    }

}
