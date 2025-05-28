package com.example.gestaosla.service;

import com.example.gestaosla.model.entity.Projeto;
import com.example.gestaosla.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> getAllProjeto() {
        return projetoRepository.findAll();
    }

    public Projeto getProjetoById(Long id) {
        return projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));
    }

    public Projeto createProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Projeto updateProjeto(Long id, Projeto projeto) {
        Projeto updateProjeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));

        updateProjeto.setTema(projeto.getTema());
        updateProjeto.setParticipantes(projeto.getParticipantes());
        updateProjeto.setProfessor_ref(projeto.getProfessor_ref());
        updateProjeto.setSala(projeto.getSala());

        return projetoRepository.save(updateProjeto);
    }

    public void deleteProjeto(Long id) {
        if (!projetoRepository.existsById(id)) {
            throw new RuntimeException("Projeto não encontrado com id: " + id);
        }
        projetoRepository.deleteById(id);
    }
}
