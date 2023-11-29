package com.murilo.prjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murilo.prjEmpresa.entities.Departamento;
import com.murilo.prjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	// construtor que recebe a dependencia
	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	// preparando as buscas pelo id
	public Departamento getDepartamentoById(Long depcodigo) {
		return departamentoRepository.findById(depcodigo).orElse(null);
	}

	// preparando a busca geral
	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	// salvando
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	// excluir
	public void deletedepartamento(Long depcodigo) {
		departamentoRepository.deleteById(depcodigo);
	}

	// fazendo o update do jogo com o optional
	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}
}