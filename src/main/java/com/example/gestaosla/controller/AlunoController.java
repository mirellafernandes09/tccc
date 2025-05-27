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
		Aluno _aluno = alunoService.save(aluno);

		if (_aluno != null) {

		return ResponseEntity.ok().body("Aluno cadastrado com sucesso");
	}

	throw new ResourceNotFoundException("Conta de usuário já cadastrada!");
	}

@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario usuario) {

		Aluno _aluno= alunoService.login(aluno.getEmail(), aluno.getSenha());

		if (_aluno != null) {
			return ResponseEntity.ok().body(_aluno);
		}
		throw new ResourceNotFoundException("Dados Incorretos!!!");
	}
	
	@PutMapping("/alterarSenha/{id}")
	public ResponseEntity<?> alterarSenha(@PathVariable long id, @RequestBody Aluno aluno) {

		Usuario _usuario = usuarioService.alterarSenha(id, usuario);

		if (_aluno != null) {
			return ResponseEntity.ok().body("Senha alterada com sucesso!");
		}
		throw new ResourceNotFoundException("Erro ao alterar a senha.");
	}
	
	@PutMapping("/inativar/{id}")
	public ResponseEntity<?> inativar(@PathVariable long id) {

		Aluno _aluno = alunoService.inativar(id);

		if (_aluno != null) {
			return ResponseEntity.ok().body("Conta de usuário inativada com sucesso!");
		}
		throw new ResourceNotFoundException("Erro ao inativar a conta de usuário.");
	}
	
	@PutMapping("/reativar/{id}")
	public ResponseEntity<?> reativar(@PathVariable long id) {

		Aluno _aluno = alunoService.reativar(id);

		if (_aluno != null) {
			return ResponseEntity.ok().body("Conta de usuário reativada com sucesso!");
		}
		throw new ResourceNotFoundException("Erro ao reativar a conta de usuário.");
	}
	

}
