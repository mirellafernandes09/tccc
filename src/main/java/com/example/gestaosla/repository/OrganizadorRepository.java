package com.example.gestaosla.repository;

import com.example.gestaosla.model.Organizador;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gestaosla.model.entity.Organizador;

public interface OrganizadorRepository extends JpaRepository<Organizador, Long>{
    
    Organizador findByEmail(String email);
}
