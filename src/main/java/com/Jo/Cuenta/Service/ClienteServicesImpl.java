package com.Jo.Cuenta.Service;

import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jo.Cuenta.Model.Entity.Cliente;
import com.Jo.Cuenta.Model.ModelDAO.IClienteDAO;

 

@Service
public class ClienteServicesImpl  implements IGenericService<Cliente> {

	
	@Autowired
	private IClienteDAO clienteDao;
	
	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	public Cliente getByID(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).get();
	}

	@Override
	public Cliente crear(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public Cliente update(Cliente cliente, Long id) {
		Cliente cl= getByID(id);
		
		cl.setNombre(cliente.getNombre());
		cl.setApellido(cliente.getApellido());
		cl.setDireccion(cliente.getDireccion());
		cl.setEmail(cliente.getEmail());
		cl.setTelefono(cliente.getTelefono());
		
		return  clienteDao.save(cl);
	}
	

	@Override
	public void delete(Long id) {
		Cliente cl= getByID(id);
		
		if(cl!=null) {
			clienteDao.delete(cl);				
		}
	}

 

 
 
 
 

}
