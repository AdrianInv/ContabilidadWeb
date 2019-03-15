package com.integra.contabilidad.dao;

import com.integra.contabilidad.bean.ControlEnvioAsiento;

public interface ArchivoPlanoDAO {

	public void eliminarImportacionArchivoPlano(String usuarioWindows, String codigoEmpresa);
	
	public void ingresarImportacionArchivoPlano(ControlEnvioAsiento archivo);
	
}
