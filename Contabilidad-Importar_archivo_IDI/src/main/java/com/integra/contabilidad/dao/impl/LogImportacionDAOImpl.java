/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
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

import com.integra.contabilidad.bean.LogImportacion;
import com.integra.contabilidad.dao.LogImportacionDAO;
import com.integra.contabilidad.dao.sp.IngresarRegistrosValidacionTablaLogSP;
import com.integra.contabilidad.dao.sp.ListarLogImportacionPorUUIDSP;

@Repository
public class LogImportacionDAOImpl implements LogImportacionDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Qualifier("dsContaAS400")
	@Autowired
	private DataSource dsContabilidadAS400;
	
	@Override
	public List<LogImportacion> listarLogPorUUID(String uuid, String codigoEmpresa) {
		ListarLogImportacionPorUUIDSP sp = new ListarLogImportacionPorUUIDSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(uuid);
	}

	@Override
	public void ingresarLogTablaValidacion(LogImportacion log) {
		IngresarRegistrosValidacionTablaLogSP sp = new IngresarRegistrosValidacionTablaLogSP(dsContabilidadAS400);
		sp.executeProcedure(log);
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