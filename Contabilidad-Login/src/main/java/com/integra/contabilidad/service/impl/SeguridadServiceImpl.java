/**
 * ************************************************************************************
 * Fecha de Creación        : 13/02/2018
 * Creado por               : Luis Villanueva
 * Nro. Orden de Trabajo    : 10624 - PSC003
 * Descripción del cambio   : Creación 
 * ************************************************************************************   
 **/
package com.integra.contabilidad.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.integra.contabilidad.bean.MenuAplicativo;
import com.integra.contabilidad.bean.UsuarioSeguridad;
import com.integra.contabilidad.service.SeguridadService;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativo;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ListarMenuAplicativoResponse;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesion;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ObtenerInfoSesionResponse;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ResultListarMenuAplicativoBean;
import com.integra.contabilidad.wsseguridad.servicio.impl.SeguridadImplStub.ResultObtenerInfoSesionBean;

@Service
public class SeguridadServiceImpl implements SeguridadService {

	@Override
	public List<MenuAplicativo> listarMenuAplicativo(String token) throws RemoteException {
		SeguridadImplStub ws = new SeguridadImplStub(); 
		List<MenuAplicativo> listaMenuAplicativo = null;
		ListarMenuAplicativo listarMenuAplicativo = new ListarMenuAplicativo();
		listarMenuAplicativo.setTokenSesion(token);
		ListarMenuAplicativoResponse menuRespuesta = ws.listarMenuAplicativo(listarMenuAplicativo);
		ResultListarMenuAplicativoBean[] listadoMenu = menuRespuesta.get_return();

		if (listadoMenu != null) {
			listaMenuAplicativo = new ArrayList<>();
			MenuAplicativo menuAplicativo;
			MenuAplicativo subMenu;
			MenuAplicativo subSubMenu;
			List<MenuAplicativo> listaSubMenu;
			List<MenuAplicativo> listaSubSubMenu;
			
			for (ResultListarMenuAplicativoBean m : listadoMenu) {
				if (("0").equals(m.getCodOpcionMenuPadre().trim())) {
					menuAplicativo = new MenuAplicativo();
					menuAplicativo.setTitulo(m.getTituloOpcionMenu());
					listaSubMenu = new ArrayList<>();
					for (ResultListarMenuAplicativoBean ms : listadoMenu) {
						if (ms.getCodOpcionMenuPadre().equals(m.getCodOpcionMenu())) {
							boolean existeSubMenu = false;
							for (ResultListarMenuAplicativoBean mss : listadoMenu) {
								if (mss.getCodOpcionMenuPadre().equals(ms.getCodOpcionMenu())) {
									existeSubMenu = true;
								}
							}
							if (!existeSubMenu) {
								subMenu = new MenuAplicativo();
								subMenu.setTitulo(ms.getTituloOpcionMenu());
								subMenu.setUrl(ms.getUrl());
								listaSubMenu.add(subMenu);
							} else {
								subMenu = new MenuAplicativo();
								subMenu.setTitulo(ms.getTituloOpcionMenu());
								listaSubSubMenu = new ArrayList<>();
								for (ResultListarMenuAplicativoBean mss : listadoMenu) {
									if (mss.getCodOpcionMenuPadre().equals(ms.getCodOpcionMenu())) {
										subSubMenu = new MenuAplicativo();
										subSubMenu.setTitulo(mss.getTituloOpcionMenu());
										subSubMenu.setUrl(mss.getUrl());
										listaSubSubMenu.add(subSubMenu);
									}
								}
								subMenu.setSubMenu(listaSubSubMenu);
								listaSubMenu.add(subMenu);
							}
							menuAplicativo.setSubMenu(listaSubMenu);
						}
					}
					listaMenuAplicativo.add(menuAplicativo);
				}
			}
		}
		return listaMenuAplicativo;
	}

	@Override
	public UsuarioSeguridad obtenerDatosSesion(String token) throws RemoteException {
		SeguridadImplStub ws = new SeguridadImplStub();
		UsuarioSeguridad usuario = null;
		ObtenerInfoSesion obtenerInfoSesion = new ObtenerInfoSesion();
		obtenerInfoSesion.setTokenSesion(token);
		ObtenerInfoSesionResponse infoResponseSession = ws.obtenerInfoSesion(obtenerInfoSesion);
		ResultObtenerInfoSesionBean resultadoResponseSession = infoResponseSession.get_return();
		if (resultadoResponseSession != null) {
			usuario = new UsuarioSeguridad();
			usuario.setCodigoUsuario(resultadoResponseSession.getCodUsuario());
			usuario.setNombre(resultadoResponseSession.getNombreUsuario());
		}
		return usuario;
	}

}