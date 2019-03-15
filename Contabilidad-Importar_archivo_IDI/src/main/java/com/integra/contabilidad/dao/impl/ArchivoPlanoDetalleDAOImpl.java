package com.integra.contabilidad.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.dao.ArchivoPlanoDetalleDAO;
import com.integra.contabilidad.dao.sp.EliminarDetalleArchivoPlanoSP;
import com.integra.contabilidad.dao.sp.IngresarDetalleArchivoPlanosSP;
import com.integra.contabilidad.dao.sp.ObtenerResultadoValidacionSP;
import com.integra.contabilidad.dao.sp.ValidarDetalleArchivoPlanoSP;
import com.integra.contabilidad.dao.sp.ValidarFacturaFormatoCorrectoSP;
import com.integra.contabilidad.reporte.bean.ValidacionArchivoPlano;

@Repository
public class ArchivoPlanoDetalleDAOImpl implements ArchivoPlanoDetalleDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Override
	public void eliminarDetalleArchivoAImportar(String usuarioWindows, String codigoEmpresa) {
		EliminarDetalleArchivoPlanoSP sp = new EliminarDetalleArchivoPlanoSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(usuarioWindows);
	}
	
	@Override
	public void ingresarDetalleArchivoAImportar(Map<String, Object> parametrosIn, String codigoEmpresa) {
		IngresarDetalleArchivoPlanosSP sp = new IngresarDetalleArchivoPlanosSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(parametrosIn);
	}
	
	@Override
	public List<ValidacionArchivoPlano> validarDetalleArchivoPlano(ControlEnvioAsiento controlAsiento, String codigoEmpresa) {
		ValidarDetalleArchivoPlanoSP sp = new ValidarDetalleArchivoPlanoSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(controlAsiento);
	}
	
	@Override
	public int isFormatoFacturaCorrecto(String usuarioWindows, String codigoEmpresa) {
		ValidarFacturaFormatoCorrectoSP sp = new ValidarFacturaFormatoCorrectoSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(usuarioWindows);
	}
	
	@Override
	public int obtenerTipoValidacion(String usuarioWindows, String codigoEmpresa) {
		ObtenerResultadoValidacionSP sp = new ObtenerResultadoValidacionSP(dsContabilidad(codigoEmpresa));
		return sp.executeProcedure(usuarioWindows);
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