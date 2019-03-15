/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.integra.contabilidad.bean.UsuarioContabilidad;
import com.integra.contabilidad.service.LoginService;
import com.integra.contabilidad.util.Constantes;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/obtenerDatosUsuario/{codigoUsuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerDatosUsuario(@PathVariable("codigoUsuario") String codigoUsuario) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
        	result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
			result.put("usuarioContabilidad", loginService.obtenerDatosUsuario(codigoUsuario));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}
	
	@RequestMapping(value = "/actualizarPeriodo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarPeriodo(@RequestBody UsuarioContabilidad usuario) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
        	result = loginService.actualizarPeriodo(usuario);
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}
	
	@RequestMapping(value = "/obtenerDatosEmpresa/{codigoEmpresa}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> obtenerDatosEmpresa(@PathVariable("codigoEmpresa") String codigoEmpresa) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new Gson();
        try {
        	result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
			result.put("empresa", loginService.obtenerDatosEmpresa(codigoEmpresa));
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}

}