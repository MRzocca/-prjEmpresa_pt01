package com.murilo.prjEmpresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.murilo.prjEmpresa.entities.Funcionario;
import com.murilo.prjEmpresa.services.FuncionarioService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Funcionarios", description = "Central dos funcionarios")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioControler {

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}

	private final FuncionarioService funcionarioServico;

	@Autowired
	public FuncionarioControler(FuncionarioService funcionarioServico) {
		this.funcionarioServico = funcionarioServico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionario(@PathVariable Long funncodigo) {
		Funcionario funcionario = funcionarioServico.getFuncionarioById(funncodigo);
		if (funcionario != null) {
			return ResponseEntity.ok(funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Funcionario createFuncionario(@RequestBody Funcionario funcionario) {
		return funcionarioServico.saveFuncionario(funcionario);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping("/")
	public ResponseEntity<List< Funcionario>>getAllFuncionario() {		
		List<Funcionario> funcionario =  funcionarioServico.getAllFuncionario();
		return ResponseEntity.ok(funcionario);
	}

	@PutMapping("/{id}")
	public Funcionario updateFuncionario(@PathVariable Long funcodigo, @RequestBody Funcionario funcionario) {
		return funcionarioServico.updateFuncionario(funcodigo, funcionario);
	}

	@DeleteMapping("/{id}")
	public void deleteFuncionario(@PathVariable Long funcodigo) {
		funcionarioServico.deletefuncionario(funcodigo);
	}
}
