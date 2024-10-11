package com.example.gestaosla.repository;


import com.example.gestaosla.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

