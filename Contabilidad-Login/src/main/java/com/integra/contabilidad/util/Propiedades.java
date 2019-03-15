package com.integra.contabilidad.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Propiedades {

	private static String urlSeguridadServicio;

	@Value("${url.seguridad.servicio}")
	public void setUrlSeguridadServicio(String urlSeguridadServicio) {
		Propiedades.urlSeguridadServicio = urlSeguridadServicio;
	}

	public static String getUrlSeguridadServicio() {
		return urlSeguridadServicio;
	}
	
}