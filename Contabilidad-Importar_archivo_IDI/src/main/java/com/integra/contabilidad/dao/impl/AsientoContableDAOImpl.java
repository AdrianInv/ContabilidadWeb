package com.integra.contabilidad.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.integra.contabilidad.bean.AsientoContable;
import com.integra.contabilidad.dao.AsientoContableDAO;
import com.integra.contabilidad.dao.sp.ListarAsientoContablePorUUIDSP;

@Repository
public class AsientoContableDAOImpl implements AsientoContableDAO {

	@Qualifier("dsContaAS400")
	@Autowired
	private DataSource dsContabilidadAS400;
	
	@Override
	public List<AsientoContable> listarAsientoContablePorUUID(String uuid) {
		ListarAsientoContablePorUUIDSP sp = new ListarAsientoContablePorUUIDSP(dsContabilidadAS400);
		return sp.executeProcedure(uuid);
	}

}