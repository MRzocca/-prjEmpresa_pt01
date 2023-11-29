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

import com.murilo.prjEmpresa.entities.Departamento;
import com.murilo.prjEmpresa.services.DepartamentoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Departamento", description = "Central de departamento")
@RestController
@RequestMapping("/departamento")
public class DepartamentoControler {

	@GetMapping("/home")
	public String paginaInicial() {
		return "index"; // Nome do seu arquivo HTML (sem a extensão)
	}

	private final DepartamentoService departamentoServico;

	@Autowired
	public DepartamentoControler(DepartamentoService departamentoServico) {
		this.departamentoServico = departamentoServico;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long depcodigo) {
		Departamento departamento = departamentoServico.getDepartamentoById(depcodigo);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoServico.saveDepartamento(departamento);
	}

	// Utilizando o ResponseEntity e RequestEntity
	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoServico.getAllDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}

	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long depcodigo, @RequestBody Departamento departamento) {
		return departamentoServico.updateDepartamento(depcodigo, departamento);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long depcodigo) {
		departamentoServico.deletedepartamento(depcodigo);
	}

}
