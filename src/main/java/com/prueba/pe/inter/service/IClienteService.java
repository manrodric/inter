package com.prueba.pe.inter.service;

import java.util.List;

import com.prueba.pe.inter.dto.*;


public interface IClienteService {
	
	
	void registrarCliente(Cliente cliente);
	public ResponseArit calculo();
	public List<Cliente> listarCliente(); 

}
