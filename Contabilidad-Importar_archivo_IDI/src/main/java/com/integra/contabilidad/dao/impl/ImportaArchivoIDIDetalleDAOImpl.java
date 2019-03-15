/**
 * ************************************************************************************
 * Fecha de Creación        : 12/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.dao.impl;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.integra.contabilidad.dao.ImportaArchivoIDIDetalleDAO;
import com.integra.contabilidad.dao.sp.ActualizarFormatoCorrectoDocumentoSP;


@Repository
public class ImportaArchivoIDIDetalleDAOImpl implements ImportaArchivoIDIDetalleDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Override
	public void actualizarFormatoCorrectoDocumento(String codigoUsuario, String codigoEmpresa) {
		ActualizarFormatoCorrectoDocumentoSP sp = new ActualizarFormatoCorrectoDocumentoSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(codigoUsuario);
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