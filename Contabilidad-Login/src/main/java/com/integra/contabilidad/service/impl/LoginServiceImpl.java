/**
 * ************************************************************************************
 * Fecha de Creación        : 07/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integra.contabilidad.bean.Empresa;
import com.integra.contabilidad.bean.UsuarioContabilidad;
import com.integra.contabilidad.dao.LoginDAO;
import com.integra.contabilidad.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioContabilidad obtenerDatosUsuario(String codigoUsuario) {
		return loginDAO.obtenerDatosUsuario(codigoUsuario);
	}

	@Override
	@Transactional
	public Map<String, Object> actualizarPeriodo(UsuarioContabilidad usuario) {
		return loginDAO.actualizarPeriodo(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa obtenerDatosEmpresa(String codigoEmpresa) {
		return loginDAO.obtenerDatosEmpresa(codigoEmpresa);
	}

}