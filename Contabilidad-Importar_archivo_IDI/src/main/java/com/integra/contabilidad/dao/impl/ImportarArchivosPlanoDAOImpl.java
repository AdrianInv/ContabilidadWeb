package com.integra.contabilidad.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.dao.ImportarArchivosPlanoDAO;
import com.integra.contabilidad.dao.sp.ObtenerEstadoArchivoPlanoSP;

@Repository
public class ImportarArchivosPlanoDAOImpl implements ImportarArchivosPlanoDAO {

	@Qualifier("dsConta04")
	@Autowired
	private DataSource dsContabilidadConta04;
	
	@Qualifier("dsConta03")
	@Autowired
	private DataSource dsContabilidadConta03;
	
	@Override
	public void obtenerEstadoRealesArchivo(ControlEnvioAsiento archivo) {
		ObtenerEstadoArchivoPlanoSP sp = new ObtenerEstadoArchivoPlanoSP(dsContabilidad(archivo.getEmpresa()));
		sp.executeProcedure(archivo);
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