package com.prueba.pe.inter.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.pe.inter.dao.*;
import com.prueba.pe.inter.dto.*;
import com.prueba.pe.inter.service.*;


@Service
public class ClienteServiceImpl implements IClienteService {

	private Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private IClienteDao clienteDao;

	@Override
	public void registrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		Date fechaM = generacionFechaMuerte(cliente);
		cliente.setFecha_probable_muerte(fechaM);
		clienteDao.save(cliente);
	}

	public Date generacionFechaMuerte(Cliente cliente) {
		Date fechaNac = cliente.getFecha_nacimiento();
		LocalDate end = LocalDate.of(2040,1, 1);
		long fechaFin = end.toEpochDay();
		LocalDate fechaN = fechaNac.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		long start = fechaN.toEpochDay();
		long randomEpochDay = ThreadLocalRandom.current().longs(start, fechaFin).findAny().getAsLong();
		Date fechaM = java.sql.Date.valueOf(LocalDate.ofEpochDay(randomEpochDay));
		return fechaM;
	}

	@Override
	public ResponseArit calculo() {
		List<Cliente> list = clienteDao.findAll();
		ResponseArit response = new ResponseArit();
		double promedio, sum1 = 0, desviacion;
		int[] array = new int[list.size()];
		int sum = 0;
		int cc = 0;
		for (Cliente customer : list) {
			int edad = customer.getEdad();
			sum = sum + edad;
			array[cc] = edad;
			cc++;
		}
		promedio = sum / (double) list.size();
		response.setPromedio(promedio);

		for (int num : array) {
			System.out.println(num);

			sum1 += Math.pow(num - promedio, 2);
		}
		desviacion = Math.sqrt(sum1 / (double) list.size());

		response.setDesviacion(desviacion);
		return response;

	}

	@Override
	public List<Cliente> listarCliente() {
		// TODO Auto-generated method stub
		return this.clienteDao.findAll();
	}

}
