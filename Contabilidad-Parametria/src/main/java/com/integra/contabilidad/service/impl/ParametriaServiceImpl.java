/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.contabilidad.bean.Fondo;
import com.integra.contabilidad.dao.ParametriaDAO;
import com.integra.contabilidad.service.ParametriaService;
import com.integra.contabilidad.util.Constantes;

@Service
public class ParametriaServiceImpl implements ParametriaService {

	@Autowired
	private ParametriaDAO parametriaDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Fondo> listarFondos(String codigoEmpresa) {
		List<Fondo> listaFondo = parametriaDAO.listarFondos(codigoEmpresa);
		List<Fondo> listaFondoActivos = new ArrayList<>();
		
		for (Fondo fondoCurrent : listaFondo) {
			if (Constantes.ESTADO_FONDO_ACTIVO.equals(fondoCurrent.getEstado())) {
				listaFondoActivos.add(fondoCurrent);
			}
		}
		return listaFondoActivos;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerEstadoPeriodo(String codigoPeriodo, String codigoEmpresa) {
		return parametriaDAO.obtenerEstadoPeriodo(codigoPeriodo, codigoEmpresa);
	}

}