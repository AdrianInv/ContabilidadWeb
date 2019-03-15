/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.controller;

import java.util.HashMap;
import java.util.List;
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
import com.google.gson.GsonBuilder;
import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.service.ImportaArchivoIDIService;
import com.integra.contabilidad.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/importarArchivosIDI")
public class ImportarArchivoIDIController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ImportarArchivoIDIController.class);

	@Autowired
	private ImportaArchivoIDIService importaArchivoIDIService;
	
	/*@RequestMapping(value = "/emitirReporteValidacion", method = RequestMethod.POST)
	public ResponseEntity<byte[]> emitirReporteValidacion(@RequestBody String parametros) {
		ResponseEntity<byte[]> response;
		try {
			response = new ResponseEntity<>(importaArchivoIDIService.emitirReporteValidacion(parametros), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			LOGGER.error(e.getMessage(), e);
		}
		return response;
	}*/
	
	@RequestMapping(value = "/procesarArchivos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> procesar(@RequestBody String parametros) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = new HashMap<>();
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		try {
			result = importaArchivoIDIService.procesar(parametros);
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_OK);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			result.put(Constantes.KEY_STATUS, Constantes.STATUS_ERROR);
			result.put(Constantes.KEY_MENSAJE, e.getMessage());
		}
		return new ResponseEntity<>(gson.toJson(result), hs);
	}
	
	@RequestMapping(value = "/emitirReporteImportacion", method = RequestMethod.POST)
	public ResponseEntity<byte[]> emitirReporteImportacion(@RequestBody String parametros) {
		ResponseEntity<byte[]> response;
		try {
			response = new ResponseEntity<>(importaArchivoIDIService.emitirReporteImportacion(parametros), HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			LOGGER.error(e.getMessage(), e);
		}
		return response;
	}

	@RequestMapping(value = "/listarArchivosTransferenciaPREMIUM/{fondo}/{empresa}/{usuarioWindows}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ControlEnvioAsiento>> listarArchivosTransferenciaPREMIUM(@PathVariable("fondo") String fondo, @PathVariable("empresa") String empresa, @PathVariable("usuarioWindows") String usuarioWindows) {
		HttpStatus hs = HttpStatus.OK;
		List<ControlEnvioAsiento> result = null;
		try {
			result = importaArchivoIDIService.listarArchivosTransferenciaPREMIUM(fondo, empresa, usuarioWindows);
		} catch (Exception e) {
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<>(result, hs);
	}
	
	@RequestMapping(value = "/validarAsientos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> validarAsientos(@RequestBody List<ControlEnvioAsiento> asientosSeleccionados) {
		HttpStatus hs = HttpStatus.OK;
		Map<String, Object> result = null;
		try {
			result = importaArchivoIDIService.validarAsientos(asientosSeleccionados);
		} catch (Exception e) {
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<>(result, hs);
	}
	
	@RequestMapping(value = "/filtrarAsientos/{year}/{mes}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ControlEnvioAsiento>> filtrarAsientos(@RequestBody List<ControlEnvioAsiento> asientosSeleccionados, @PathVariable("year") String year, @PathVariable("mes") String mes) {
		HttpStatus hs = HttpStatus.OK;
		List<ControlEnvioAsiento> result = null;
		try {
			result = importaArchivoIDIService.filtrarAsientos(asientosSeleccionados, year, mes);
		} catch (Exception e) {
			hs = HttpStatus.INTERNAL_SERVER_ERROR;
			LOGGER.error(e.getMessage(), e);
		}
		return new ResponseEntity<>(result, hs);
	}

}