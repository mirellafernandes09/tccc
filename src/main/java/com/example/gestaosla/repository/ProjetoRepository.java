package com.example.gestaosla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaosla.model.entity.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
}
