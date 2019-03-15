package com.integra.contabilidad.dao;

import java.util.List;
import java.util.Map;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;

public interface ArchivoPlanoDetalleDAO {

	public void eliminarDetalleArchivoAImportar(String usuarioWindows, String codigoEmpresa);
	
	public void ingresarDetalleArchivoAImportar(Map<String, Object> parametrosIn, String codigoEmpresa);
	
	public List<ValidacionArchivoPlano> validarDetalleArchivoPlano(ControlEnvioAsiento controlAsiento, String codigoEmpresa);
	
	public int isFormatoFacturaCorrecto(String usuarioWindows, String codigoEmpresa);
	
	public int obtenerTipoValidacion(String usuarioWindows, String codigoEmpresa);
	
}
