package com.Jo.Cuenta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jo.Cuenta.Model.Entity.Cliente;
import com.Jo.Cuenta.Service.ClienteServicesImpl;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteServicesImpl clienteServices;
	
	
	@GetMapping("/")
	public List<Cliente> getAll() {
		return clienteServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Cliente getById(@PathVariable Long id) {
		return clienteServices.getByID(id);
	}
	
	@PostMapping("/")
	public Cliente nuevo(@RequestBody Cliente cliente) {
		return clienteServices.crear(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente update(@RequestBody Cliente cliente,@PathVariable Long id) {
		return clienteServices.update(cliente, id);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable Long id) {
		  clienteServices.delete(id);
	}
}
