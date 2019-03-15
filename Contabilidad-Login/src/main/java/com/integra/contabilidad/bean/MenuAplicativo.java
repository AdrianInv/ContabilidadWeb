package com.integra.contabilidad.bean;

import java.io.Serializable;
import java.util.List;

public class MenuAplicativo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String url;
	private List<MenuAplicativo> subMenu;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuAplicativo> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<MenuAplicativo> subMenu) {
		this.subMenu = subMenu;
	}

}