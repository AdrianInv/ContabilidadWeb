package com.integra.contabilidad.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretParametro {
	
	@JsonProperty("CONTABILIDAD_WEB_CONTA04_URL")
	private String contabilidadWebConta04Url;
	
	@JsonProperty("CONTABILIDAD_WEB_CONTA04_USR")
	private String contabilidadWebConta04Usr;
	
	@JsonProperty("CONTABILIDAD_WEB_CONTA04_PSW")
	private String contabilidadWebConta04Psw;
	
	
	@JsonProperty("CONTABILIDAD_WEB_KEY_ENCRIPTACION")
	private String keyEncriptacion;
	
	
	public String getContabilidadWebConta04Url() {
		return contabilidadWebConta04Url;
	}

	public void setContabilidadWebConta04Url(String contabilidadWebConta04Url) {
		this.contabilidadWebConta04Url = contabilidadWebConta04Url;
	}

	public String getContabilidadWebConta04Usr() {
		return contabilidadWebConta04Usr;
	}

	public void setContabilidaWebConta04Usr(String contabilidadWebConta04Usr) {
		this.contabilidadWebConta04Usr = contabilidadWebConta04Usr;
	}

	public String getContabilidadWebConta04Psw() {
		return contabilidadWebConta04Psw;
	}

	public void setContabilidadWebConta04Psw(String contabilidadWebConta04Psw) {
		this.contabilidadWebConta04Psw = contabilidadWebConta04Psw;
	}

	public String getKeyEncriptacion() {
		return keyEncriptacion;
	}

	public void setKeyEncriptacion(String keyEncriptacion) {
		this.keyEncriptacion = keyEncriptacion;
	}
	
	



}
