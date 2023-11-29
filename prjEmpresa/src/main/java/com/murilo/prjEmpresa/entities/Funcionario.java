package com.murilo.prjEmpresa.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long funcodigo;

	@NotNull
	@NotBlank
	private String funnome;

	@NotNull
	@NotBlank
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate funnascimento;

	@NotNull
	@NotBlank
	private long funsalario;

	public Funcionario() {

	}

	public Funcionario(Long funcodigo, String funnome, LocalDate funnascimento, Long funsalario) {
		super();
		this.funcodigo = funcodigo;
		this.funnome = funnome;
		this.funnascimento = funnascimento;
		this.funsalario = funsalario;
	}

	public Long getFuncodigo() {
		return funcodigo;
	}

	public void setFuncodigo(Long funcodigo) {
		this.funcodigo = funcodigo;
	}

	public String getFunnome() {
		return funnome;
	}

	public void setFunnome(String funnome) {
		this.funnome = funnome;
	}

	public LocalDate getFunnascimento() {
		return funnascimento;
	}

	public void setFunnascimento(LocalDate funnascimento) {
		this.funnascimento = funnascimento;
	}

	public Long getFunsalario() {
		return funsalario;
	}

	public void setFunsalario(Long funsalario) {
		this.funsalario = funsalario;
	}
}