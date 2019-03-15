package com.integra.contabilidad.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.dao.ArchivoPlanoDAO;
import com.integra.contabilidad.dao.sp.EliminarImportacionArchivosPlanosSP;
import com.integra.contabilidad.dao.sp.IngresarImportacionArchivoPlanosIISP;

@Repository
public class ArchivoPlanoDAOImpl implements ArchivoPlanoDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Override
	public void eliminarImportacionArchivoPlano(String usuarioWindows, String codigoEmpresa) {
		EliminarImportacionArchivosPlanosSP sp = new EliminarImportacionArchivosPlanosSP(dsContabilidad(codigoEmpresa));
		sp.executeProcedure(usuarioWindows);
	}
	
	@Override
	public void ingresarImportacionArchivoPlano(ControlEnvioAsiento controlAsiento) {
		IngresarImportacionArchivoPlanosIISP sp = new IngresarImportacionArchivoPlanosIISP(dsContabilidad(controlAsiento.getEmpresa()));
		sp.executeProcedure(controlAsiento);
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
