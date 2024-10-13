package com.example.gestaosla.controller;

import com.example.gestaosla.model.Organizador;
import com.example.gestaosla.Service.OrganizadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/organizador")
public class OrganizadorController {

    @Autowired
    private OrganizadorService organizadorService;

    @GetMapping
    public List<Organizador> getAllOrganizador() {
        return organizadorService.getAllOrganizador();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizador> getOrganizadorById(@PathVariable Long id) {
        Optional<Organizador> organizador = organizadorService.getOrganizadorById(id);
        if (organizador.isPresent()) {
            return ResponseEntity.ok(organizador.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public Organizador
    createOrganizador(@RequestBody Organizador organizador) {
        return organizadorService.createOrganizador(organizador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizador> updateOrganizador(@PathVariable Long id, @RequestBody Organizador organizador) {
        Organizador updateOrganizador = organizadorService.updateOrganizador(id, organizador);
        if (updateOrganizador != null) {
            return ResponseEntity.ok(updateOrganizador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteOrganizador(@PathVariable Long matricula) {
        organizadorService.deleteOrganizador(matricula);
        return
                ResponseEntity.noContent().build();
    }
}