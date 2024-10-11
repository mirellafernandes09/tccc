package com.example.gestaosla.controller;

import com.example.gestaosla.model.Professor;
import com.example.gestaosla.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessor() {
        return professorService.getAllProfessor();
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long matricula) {
        Optional<Professor> professor = professorService.getProfessorById(matricula);
        if (professor.isPresent()) {
            return ResponseEntity.ok(professor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Professor
    createProfessor(@RequestBody Professor professor) {
        return professorService.createProfessor(professor);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long matricula, @RequestBody Professor professor) {
        Professor updateProfessor = professorService.updateProfessor(matricula, professor);
        if (updateProfessor != null) {
            return ResponseEntity.ok(updateProfessor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long matricula) {
        professorService.deleteProfessor(matricula);
        return
                ResponseEntity.noContent().build();
    }
}