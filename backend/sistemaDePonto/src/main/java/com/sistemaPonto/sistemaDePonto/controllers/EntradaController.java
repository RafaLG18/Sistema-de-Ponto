package com.sistemaPonto.sistemaDePonto.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionario;
import com.sistemaPonto.sistemaDePonto.entidades.Registro;
import com.sistemaPonto.sistemaDePonto.respositorios.RepositorioRegistroFuncionario;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/Entrada")
public class EntradaController {
    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionarios() throws SQLException {
        
        return ResponseEntity.ok(RepositorioRegistroFuncionario.getMyInstance().read());
        
    }
    @PostMapping
    public ResponseEntity<?> CadastroRegistro(@RequestBody Registro registro) throws SQLException {
        System.out.println("Recebido no backend: " + registro.getIdFuncionario());
        System.out.println("Recebido no backend: " + registro.getData());
        System.out.println("Recebido no backend: " + registro.getHora());
        try {
            RepositorioRegistroFuncionario.getMyInstance().insertRegistro(registro);
            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Erro ao cadastrar o funcionario, contate o desenvolvedor");
        }   
    }   

}
