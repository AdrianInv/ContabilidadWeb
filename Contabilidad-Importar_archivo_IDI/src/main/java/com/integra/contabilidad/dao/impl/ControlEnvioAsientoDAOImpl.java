package com.integra.contabilidad.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.ControlEnvioAsiento;
import com.integra.contabilidad.dao.ControlEnvioAsientoDAO;
import com.integra.contabilidad.dao.sp.ListarAsientoATransferirPremiumSP;

@Repository
public class ControlEnvioAsientoDAOImpl implements ControlEnvioAsientoDAO {

	@Qualifier("dsContaAS400")
	@Autowired
	private DataSource dsContabilidadAS400;
	
	@Override
	public List<ControlEnvioAsiento> listarAsientosATransferirPREMIUM(String fondo) {
		ListarAsientoATransferirPremiumSP sp = new ListarAsientoATransferirPremiumSP(dsContabilidadAS400);
		return sp.executeProcedure(fondo);
	}

}