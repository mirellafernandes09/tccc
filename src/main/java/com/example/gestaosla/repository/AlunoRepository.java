package com.example.gestaosla.repository;

import com.example.gestaosla.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaosla.model.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findByEmail(String email);

}

