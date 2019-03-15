/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.integra.contabilidad.service.ParametriaService;
import com.integra.contabilidad.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/parametria")
public class ParametriaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ParametriaController.class);
	
	@Autowired
	private ParametriaService parametriaService;
	
	@RequestMapping(value = "/listarFondos/{codigoEmpresa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> listarFondos(@PathVariable("codigoEmpresa") String codigoEmpresa) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
			result.put("listaFondos", parametriaService.listarFondos(codigoEmpresa));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}
	
	@RequestMapping(value = "/obtenerEstadoPeriodo/{codigoPeriodo}/{codigoEmpresa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerEstadoPeriodo(@PathVariable("codigoPeriodo") String codigoPeriodo, @PathVariable("codigoEmpresa") String codigoEmpresa) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
			result.put("estadoPeriodo", parametriaService.obtenerEstadoPeriodo(codigoPeriodo, codigoEmpresa));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}
	
}