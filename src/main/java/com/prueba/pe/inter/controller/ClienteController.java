package com.prueba.pe.inter.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.prueba.pe.inter.dto.*;
import com.prueba.pe.inter.service.IClienteService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/rest")
@Api(value = "service cliente", description = "")
public class ClienteController {
	private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);
	@Autowired
	private IClienteService clienteService;

	@PostMapping(value = "creacliente", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespuestaApi> guardarFeedBack(@RequestBody Cliente cliente) {
		try {
			clienteService.registrarCliente(cliente);
			return new ResponseEntity<RespuestaApi>(new RespuestaApi("OK", ""), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseArit> calculo() {
		try {

			ResponseArit obj = clienteService.calculo();
			return new ResponseEntity<ResponseArit>(obj, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> listaCliente() {
		try {

			return new ResponseEntity<List<Cliente>>(clienteService.listarCliente(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
