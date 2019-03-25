package com.prueba.pe.inter.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.pe.inter.dto.Cliente;


@Repository
public interface IClienteDao extends JpaRepository<Cliente, Integer>{
	
	
}
