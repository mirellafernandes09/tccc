package com.example.gestaosla.model;

import jakarta.persistence.*;

@Entity
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sala;

    private String tema;
    private String participantes;
    private String professor_ref;

    public Long getSala() {
        return sala;
    }

    public void setSala(Long sala) {
        this.sala = sala;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getParticipantes() {
        return participantes;
    }

    public void setParticipantes(String participantes) {
        this.participantes = participantes;
    }

    public String getProfessor_ref() {
        return professor_ref;
    }

    public void setProfessor_ref(String professor_ref) {
        this.professor_ref = professor_ref;
    }
}