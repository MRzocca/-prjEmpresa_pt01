package com.murilo.prjEmpresa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.murilo.prjEmpresa.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

}