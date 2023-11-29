package com.murilo.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilo.prjEmpresa.entities.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}