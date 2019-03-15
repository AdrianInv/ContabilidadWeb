/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.dao.MovimientoDAO;
import com.integra.contabilidad.dao.sp.ObtenerDIARCYRESMOVSP;
import com.integra.contabilidad.dao.sp.ObtenerValidacionMovimientoSP;

@Repository
public class MovimientoDAOImpl implements MovimientoDAO {

	@Qualifier("dsContaAS400")
	@Autowired
	private DataSource dsContabilidadAS400;
	
	@Qualifier("dsCuentasIndividuales")
	@Autowired
	private DataSource dsCuentasIndividuales;
	
	@Override
	public Map<String, Object> obtenerDiarxYCantRegResmov() {
		ObtenerDIARCYRESMOVSP sp = new ObtenerDIARCYRESMOVSP(dsContabilidadAS400);
		return sp.executeProcedure();
	}

	@Override
	public int obtenerValidacionMovimiento(Map<String, Object> parametros) {
		ObtenerValidacionMovimientoSP sp = new ObtenerValidacionMovimientoSP(dsCuentasIndividuales); 
		return sp.executeProcedure(parametros);
	}

}
