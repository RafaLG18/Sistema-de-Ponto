package com.sistemaPonto.sistemaDePonto.respositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemaPonto.sistemaDePonto.entidades.Registro;

public class repositorioRegistro {
    public void insert(String nome_funcionario,Registro registro) throws SQLException{
        String sql = "insert into registro (id_funcionario,data_registro, hora_chegada) " + "values(?,?,?)";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setString(1, registro.getData());
            pstm.setString(2, registro.getHora());
            pstm.execute();
        }    
    }

    public List<Registro> resgistros(int id_funcionario)throws SQLException{
        
        List<Registro> registros=new ArrayList<Registro>();
        

        String sql = "select data_registro,hora_chegada from registro where id ="+"?";
        try (PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql)) {
            pstm.setInt(1, id_funcionario);
            ResultSet query = pstm.executeQuery();
            while (query.next()) {
                Registro registro=new Registro();

                String data = query.getString("data_registro");
                String hora = query.getString("hora_registro");
                
                registro.setData(data);
                registro.setHora(hora);

                registros.add(registro);
            }
            return registros;
        }
    }

}
