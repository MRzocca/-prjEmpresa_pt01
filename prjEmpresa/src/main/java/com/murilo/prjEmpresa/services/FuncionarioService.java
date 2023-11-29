package com.murilo.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.prjEmpresa.entities.Funcionario;
import com.murilo.prjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	// construtor que recebe a dependencia
	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	// preparando as buscas pelo id
	public Funcionario getFuncionarioById(Long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	// preparando a busca geral
	public List<Funcionario> getAllFuncionario() {
		return funcionarioRepository.findAll();
	}

	// salvando
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	// excluir
	public void deletefuncionario(Long depcodigo) {
		funcionarioRepository.deleteById(depcodigo);
	}

	// fazendo o update do jogo com o optional
	public Funcionario updateFuncionario(Long funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario>funcionarioOptional = funcionarioRepository.findById(funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());

			return funcionarioRepository.save(funcionarioExistente);
		} else {
			return null;
		}
	}
}
