package com.sistemaPonto.sistemaDePonto.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaPonto.sistemaDePonto.entidades.Registro;
import com.sistemaPonto.sistemaDePonto.respositorios.RepositorioRegistroFuncionario;


@RestController
@RequestMapping("/Registros")
public class RegistroController {
    // Pega todos os registros de um funcionário específico
    @GetMapping
    public ResponseEntity<List<Registro>> getRegistroFromFuncionarios(int key) throws SQLException {
        
        return ResponseEntity.ok(RepositorioRegistroFuncionario.getMyInstance().read(key));
        
    }
    
}
