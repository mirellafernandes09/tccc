package com.example.gestaosla.Service;

import com.example.gestaosla.model.Professor;
import com.example.gestaosla.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessor() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long matricula) {
        return professorRepository.findById(matricula);
    }

    public Professor createProfessor(Professor professor) {
        return
                professorRepository.save(professor);
    }

    public Professor updateProfessor(Long matricula, Professor professor) {
        Optional<Professor> existingProfessor= professorRepository.findById(matricula);
        if (existingProfessor.isPresent()) {
            Professor updateProfessor = existingProfessor.get();

            updateProfessor.setNome(professor.getNome());
            updateProfessor.setEmail(professor.getEmail());
        }
        return null;
    }

    public void deleteProfessor(Long matricula) {
        professorRepository.deleteById(matricula);
    }

}