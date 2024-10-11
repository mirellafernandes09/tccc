package com.example.gestaosla.controller;

import com.example.gestaosla.model.Aluno;
import com.example.gestaosla.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<Aluno> getAllAluno() {
        return alunoService.getAllAluno();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long matricula) {
        Optional<Aluno> aluno = alunoService.getAlunoById(matricula);
        if (aluno.isPresent()) {
            return ResponseEntity.ok(aluno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Aluno
    createAluno(@RequestBody Aluno aluno) {
        return alunoService.createAluno(aluno);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {
        Aluno updateAluno = alunoService.updateAluno(matricula, aluno);
        if (updateAluno != null) {
            return ResponseEntity.ok(updateAluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long matricula) {
        alunoService.deleteAluno(matricula);
        return
                ResponseEntity.noContent().build();
    }
}
