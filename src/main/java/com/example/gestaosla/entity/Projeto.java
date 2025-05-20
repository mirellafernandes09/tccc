package br.itb.projeto.sla.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="projeto")
public class Projeto {

	@Id
	@GeneratedValue
	private long id;
	private String tema;
	private String sala;
	private String participantes;


	@ManyToOne
	@JoinColumn (name = "aluno_id")
	private Aluno aluno;

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public String getParticipantes() {
		return participantes;
	}


	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}


	public Aluno getAluno() {
		return aluno;
	}


	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}




	
}
