package com.example.gestaosla.controller;

import com.example.gestaosla.model.Projeto;
import com.example.gestaosla.Service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public List<Projeto> getAllProjeto() {
        return projetoService.getAllProjeto();
    }

    @GetMapping("/{sala}")
    public ResponseEntity<Projeto> getProjetoById(@PathVariable Long sala) {
        Optional<Projeto> projeto = projetoService.getProjetoById(sala);
        if (projeto.isPresent()) {
            return ResponseEntity.ok(projeto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Projeto
    createProjeto(@RequestBody Projeto projeto) {
        return projetoService.createProjeto(projeto);
    }

    @PutMapping("/{sala}")
    public ResponseEntity<Projeto> updateProjeto(@PathVariable Long sala, @RequestBody Projeto projeto) {
         Projeto updateProjeto = projetoService.updateProjeto(sala, projeto);
        if (updateProjeto != null) {
            return ResponseEntity.ok(updateProjeto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{sala}")
    public ResponseEntity<Void> deleteProjeto(@PathVariable Long sala) {
        projetoService.deleteProjeto(sala);
        return
                ResponseEntity.noContent().build();
    }
}