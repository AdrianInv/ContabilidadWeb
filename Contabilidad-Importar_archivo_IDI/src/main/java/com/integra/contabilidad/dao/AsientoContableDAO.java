package com.integra.contabilidad.dao;

import java.util.List;

import com.integra.contabilidad.bean.AsientoContable;

public interface AsientoContableDAO {
	
	public List<AsientoContable> listarAsientoContablePorUUID(String uuid);
	
}