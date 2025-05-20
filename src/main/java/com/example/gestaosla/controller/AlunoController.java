package com.example.gestaosla.controller;

import com.example.gestaosla.model.Aluno;
import com.example.gestaosla.Service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @GetMapping
    public CategoriaAluno (CategoriaAluno categoriaAluno) {
        super();
		this.categoriaAluno = categoriaAluno;
    }
    

    @GetMapping("/{matricula}")
    public  String getTest() {
		return "Olá, Categoria!";

	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id) {

		Aluno aluno = alunoService.findById(id);

		if ( aluno != null) {
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
		} else {
			throw new ResourceNotFoundException("*** Aluno não encontrada! *** ");
		}

	}

   @GetMapping("/findAll")
	public ResponseEntity<List<Aluno>> findAll() {

		List<Aluno> alunos = alunoService.findAll();

		return new ResponseEntity<List<Aluno>>(alunos, HttpStatus.OK);
	}


    @PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Aluno aluno) {
		alunoService.save(aluno);
		return ResponseEntity.ok().body("Aluno cadastrado com sucesso");
	}

}
