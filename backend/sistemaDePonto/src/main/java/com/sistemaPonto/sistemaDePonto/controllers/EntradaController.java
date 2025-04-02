package com.sistemaPonto.sistemaDePonto.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionario;
import com.sistemaPonto.sistemaDePonto.entidades.Registro;
import com.sistemaPonto.sistemaDePonto.respositorios.RepositorioRegistroFuncionario;


@RestController
@RequestMapping("/Entrada")
public class EntradaController {
    @GetMapping
    public ResponseEntity<List<Funcionario>> getFuncionarios() throws SQLException {
        
        return ResponseEntity.ok(RepositorioRegistroFuncionario.getMyInstance().read());
        
    }
    @PostMapping
    public void CadastroRegistro(@RequestBody Registro registro) throws SQLException {
        RepositorioRegistroFuncionario.getMyInstance().insert(registro);
    }
    

}
