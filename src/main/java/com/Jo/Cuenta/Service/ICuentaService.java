package com.Jo.Cuenta.Service;

import com.Jo.Cuenta.Model.Entity.Cuenta;
import com.Jo.Cuenta.Model.Entity.EstadodeCuenta;

public interface ICuentaService extends IGenericService<Cuenta> {
	
	 boolean existeCuentaActiva(EstadodeCuenta estado);
	 
	 Cuenta finalizarCuenta (Long id);

}
