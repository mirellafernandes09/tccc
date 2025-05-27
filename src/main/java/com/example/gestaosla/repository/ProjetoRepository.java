package com.example.gestaosla.repository;

import com.example.gestaosla.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaosla.model.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
}
