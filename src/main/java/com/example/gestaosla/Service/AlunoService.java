package com.example.gestaosla.Service;

import com.example.gestaosla.model.Aluno;
import com.example.gestaosla.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private AlunoRepository alunoRepository;
public AlunoService(AlunoRepository alunoRepository) {
		super();
		this.alunoRepository = alunoRepository;
	}

	public Aluno findById(long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);

		if (aluno.isPresent()) {
			return aluno.get();
		}
		return null;
	}

	public List<Aluno> findAll() {
		List<Aluno> aluno = alunoRepository.findAll();
		return aluno;
	}

	@Transactional
	public Aluno save(Aluno aluno) {

		Aluno _aluno = alunoRepository.findByEmail(aluno.getEmail());

		if (_aluno == null) {

			String senha = Base64.getEncoder().encodeToString(aluno.getSenha().getBytes());

			aluno.setSenha(senha);
			aluno.setDataCadastro(LocalDateTime.now());
			aluno.setStatusAluno("ATIVO");

			return alunoRepository.save(aluno);
		}
		return null;
	}

	@Transactional
	public Aluno login(String email, String senha) {

		Aluno _aluno = usuarioRepository.findByEmail(email);

		if (_aluno != null) {
			if (_aluno.getStatusUsuario().equals("ATIVO")) {
				
				byte[] decodedPass = Base64.getDecoder()
											.decode(__aluno.getSenha());

				if (new String(decodedPass).equals(senha)) {
					return _aluno;
				}
			}
		}
		return null;
	}
	
	@Transactional
	public Aluno alterarSenha(long id, Aluno aluno) {
		Optional<Aluno>_aluno = alunoRepository.findById(id);
		
		if (_aluno.isPresent()) {
			Aluno alunoAtualizado = _aluno.get();
			
			String senha = Base64.getEncoder()
									.encodeToString(aluno.getSenha().getBytes());

			alunoAtualizado.setSenha(senha);
			alunoAtualizado.setDataCadastro(LocalDateTime.now());
			alunoAtualizado.setStatusAluno("ATIVO");

			return AlunoRepository.save(alunoAtualizado);
		}
		return null;
	}
	
	@Transactional
	public Aluno inativar(long id) {
		Optional<Aluno> _aluno = alunoRepository.findById(id);
		
		String senhaPadrao = "12345678";
		
		if (_aluno.isPresent()) {
			Aluno alunoAtualizado = _aluno.get();
			
			String senha = Base64.getEncoder()
									.encodeToString(senhaPadrao.getBytes());

			 alunoAtualizado.setSenha(senha);
			 alunoAtualizado.setDataCadastro(LocalDateTime.now());
			 alunoAtualizado.setStatusAluno("INATIVO");

			return  alunoRepository.save(alunoAtualizado);
		}
		return null;
	}

	@Transactional
	public Aluno reativar(long id) {
		Optional<Aluno> _aluno = alunoRepository.findById(id);
		
		String senhaPadrao = "12345678";
		
		if (_aluno.isPresent()) {
			Aluno alunoAtualizado = _aluno.get();
			
			String senha = Base64.getEncoder()
									.encodeToString(senhaPadrao.getBytes());

			alunoAtualizado.setSenha(senha);
			alunoAtualizado.setDataCadastro(LocalDateTime.now());
			alunoAtualizado.setStatusAluno("ATIVO");

			return alunoRepository.save(alunoAtualizado);
		}
		return null;
	}
}

