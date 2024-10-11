package com.example.gestaosla.Service;

import com.example.gestaosla.model.Aluno;
import com.example.gestaosla.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAluno() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> getAlunoById(Long matricula) {
        return alunoRepository.findById(matricula);
    }

    public Aluno createAluno(Aluno aluno) {
        return
                alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long matricula, Aluno aluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(matricula);
        if (existingAluno.isPresent()) {
            Aluno updateAluno = existingAluno.get();

            updateAluno.setNome(aluno.getNome());
            updateAluno.setCurso(aluno.getCurso());
            updateAluno.setTurma(aluno.getTurma());
            updateAluno.setEmail(aluno.getEmail());
        }
        return null;
    }

    public void deleteAluno(Long matricula) {
        alunoRepository.deleteById(matricula);
    }

}
