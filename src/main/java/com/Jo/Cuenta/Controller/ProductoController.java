package com.Jo.Cuenta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jo.Cuenta.Model.Entity.Producto;
import com.Jo.Cuenta.Service.IProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = { "http://localhost:3000" })
public class ProductoController {

	@Autowired
	private IProductoService productoServices;
	
	@GetMapping("/")
	public List<Producto> productos () {
		return productoServices.getAllProductos();
	}
	
	@GetMapping("/{id}")
	public Producto productoById (@PathVariable Long id) {
		return productoServices.getProductoByID(id);
	}
	@PostMapping("/")
	public Producto nuevoProducto(@RequestBody Producto productoNuevo) {
		return productoServices.crearProducto(productoNuevo);
	}
	
	@PutMapping("/{id}")
	public Producto updateProducto(@RequestBody Producto producto, @PathVariable Long id) {
		return productoServices.updateProducto(producto, id);		
	}
	@DeleteMapping("/{id}")
	public void delete(  @PathVariable Long id) {
		 productoServices.deleteProducto(id);		
	}

}

