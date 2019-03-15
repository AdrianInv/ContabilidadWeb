/**
 * ************************************************************************************
 * Fecha de Creación        : 08/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.Fondo;
import com.integra.contabilidad.dao.ParametriaDAO;
import com.integra.contabilidad.dao.sp.ListarFondosSP;
import com.integra.contabilidad.dao.sp.ObtenerEstadoPeriodoSP;

@Repository
public class ParametriaDAOImpl implements ParametriaDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Override
	public List<Fondo> listarFondos(String codigoEmpresa) {
		ListarFondosSP sp = new ListarFondosSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(codigoEmpresa);
	}

	@Override
	public Integer obtenerEstadoPeriodo(String codigoPeriodo, String codigoEmpresa) {
		ObtenerEstadoPeriodoSP sp = new ObtenerEstadoPeriodoSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(codigoPeriodo);
	}

	private DataSource dsContabilidad(String codigoEmpresa) {
		if ("04".equals(codigoEmpresa)) {
			return dsContabilidadConta04;
		} else if ("03".equals(codigoEmpresa)) {
			return dsContabilidadConta03;
		}
		return dsContabilidadConta04;
	}
}