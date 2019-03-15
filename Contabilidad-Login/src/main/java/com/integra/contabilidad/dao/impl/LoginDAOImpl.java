/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
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

import com.integra.contabilidad.bean.Empresa;
import com.integra.contabilidad.bean.UsuarioContabilidad;
import com.integra.contabilidad.dao.LoginDAO;
import com.integra.contabilidad.dao.sp.ActualizarPeriodoUsuarioSP;
import com.integra.contabilidad.dao.sp.ObtenerDatosEmpresaSP;
import com.integra.contabilidad.dao.sp.ObtenerDatosUsuarioSP;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Qualifier("dsPremMain")
	@Autowired
	private DataSource dsContabilidadPremMain;
	
	@Override
	public UsuarioContabilidad obtenerDatosUsuario(String codigoUsuario) {
		ObtenerDatosUsuarioSP sp = new ObtenerDatosUsuarioSP(dsContabilidadPremMain);
		return sp.executeProcedure(codigoUsuario);
	}

	@Override
	public Map<String, Object> actualizarPeriodo(UsuarioContabilidad usuario) {
		ActualizarPeriodoUsuarioSP sp = new ActualizarPeriodoUsuarioSP(dsContabilidadPremMain);
		return sp.executeProcedure(usuario);
	}

	@Override
	public Empresa obtenerDatosEmpresa(String codigoEmpresa) {
		ObtenerDatosEmpresaSP sp = new ObtenerDatosEmpresaSP(dsContabilidadPremMain);
		return sp.executeProcedure(codigoEmpresa);
	}
	
}