/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service;

import java.util.List;

import com.integra.contabilidad.bean.Fondo;

public interface ParametriaService {

	public List<Fondo> listarFondos(String codigoEmpresa);
	
	public Integer obtenerEstadoPeriodo(String codigoPeriodo, String codigoEmpresa);
	
}