package com.Jo.Cuenta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jo.Cuenta.Model.Entity.Cuenta;
import com.Jo.Cuenta.Model.Entity.EstadodeCuenta;
import com.Jo.Cuenta.Model.Entity.LineaDeCuenta;
import com.Jo.Cuenta.Model.ModelDAO.CuentaDAO;

@Service
public class CuentaServicesImpl implements ICuentaService {

	
	@Autowired
	private CuentaDAO cuentaDao;
	
	@Override
	public List<Cuenta> getAll() {
		// TODO Auto-generated method stub
		return cuentaDao.findAll();
	}

	@Override
	public Cuenta getByID(Long id) {
		// TODO Auto-generated method stub
		return cuentaDao.findById(id).orElse(null);
	}

	@Override
	public Cuenta crear(Cuenta producto) {
		
		
		if(!existeCuentaActiva(EstadodeCuenta.activa)) {
			Cuenta cuenta = cuentaDao.save(producto);		
		}
		return null;
	}

	@Override
	public Cuenta update(Cuenta cuenta, Long id) {
		
		Cuenta cuentaAct=getByID(id);
		
		if(cuenta!=null) {
			cuentaAct.setDescripcion(cuenta.getDescripcion());
			cuentaAct.setLineasCuenta(cuenta.getLineasCuenta());
			return cuentaDao.save(cuentaAct);
		}
		
		return null;
	}
	
 
	public Cuenta agregarLineaDeCuenta(List<LineaDeCuenta> lineasCuenta, Long id) {
		
		Cuenta cuentaAct=getByID(id);
		
		 
		
		 
			for (LineaDeCuenta lc : lineasCuenta) {
				
				if(lc!=null) {
					
					cuentaAct.addLineaCuenta(lc);
				}
			}
			
			//cuenta.getLineasCuenta().stream().map(cu-> cuentaAct.getLineasCuenta().add(cu));
			//cuentaAct.setLineasCuenta(cuenta.getLineasCuenta());
			return cuentaDao.save(cuentaAct);
	 	 
		
		 
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeCuentaActiva(EstadodeCuenta estado) {
		// TODO Auto-generated method stub
		return cuentaDao.existsByEstado(estado);
	}

	@Override
	public Cuenta finalizarCuenta(Long id) {
		Cuenta cuentaAct=getByID(id);
		if(cuentaAct!=null) {
			cuentaAct.FinalizrCuenta();
			cuentaDao.save(cuentaAct);
		}
		
		return null;
	}
 

}
