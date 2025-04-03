package com.sistemaPonto.sistemaDePonto.controllers;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistemaPonto.sistemaDePonto.entidades.Funcionario;
import com.sistemaPonto.sistemaDePonto.respositorios.RepositorioRegistroFuncionario;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/Cadastro")
public class CadastroController {
    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody Funcionario funcionario) {
        try {
            RepositorioRegistroFuncionario.getMyInstance().insert(funcionario);

            return ResponseEntity.ok().build();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Erro ao cadastrar o funcionario, contate o desenvolvedor");
        }
    }
}
