package com.example.gestaosla.Service;

import com.example.gestaosla.model.Projeto;
import com.example.gestaosla.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getAllProjeto() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> getProfessorById(Long sala) {
        return projetoRepository.findById(sala);
    }

    public Projeto createProjeto(Projeto projeto) {
        return
                projetoRepository.save(projeto);
    }

    public Projeto updateProfessor(Long sala, Projeto projeto) {
        Optional<Projeto> existingProjeto= projetoRepository.findById(sala);
        if (existingProjeto.isPresent()) {
            Projeto updateProjeto = existingProjeto.get();

           updateProjeto.setTema(projeto.getTema());
           updateProjeto.setParticipantes(projeto.getParticipantes());
           updateProjeto.setProfessor_ref(projeto.getProfessor_ref());
           updateProjeto.setSala(projeto.getSala());
        }
        return null;
    }

    public void deleteProjeto(Long sala) {
        projetoRepository.deleteById(sala);
    }

}
