package com.integra.contabilidad.dao;

import java.util.List;

import com.integra.contabilidad.bean.ControlEnvioAsiento;

public interface ControlEnvioAsientoDAO {

	public List<ControlEnvioAsiento> listarAsientosATransferirPREMIUM(String fondo);
	
}
