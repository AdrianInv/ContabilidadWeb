package com.integra.contabilidad.bean;

import java.io.Serializable;

public class UsuarioSeguridad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String codigoUsuario;
	private String nombre;
	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}