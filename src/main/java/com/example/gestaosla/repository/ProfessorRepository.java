package com.example.gestaosla.repository;


import com.example.gestaosla.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaosla.model.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}