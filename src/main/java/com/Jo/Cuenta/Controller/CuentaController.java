package com.Jo.Cuenta.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jo.Cuenta.Model.Entity.Cuenta;
import com.Jo.Cuenta.Model.Entity.EstadodeCuenta;
import com.Jo.Cuenta.Model.Entity.LineaDeCuenta;
import com.Jo.Cuenta.Model.Entity.Producto;
import com.Jo.Cuenta.Service.CuentaServicesImpl;
import com.Jo.Cuenta.Service.ProductoServicesImpl;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	private CuentaServicesImpl cuentaService;
	@Autowired
	private ProductoServicesImpl productoService;
	
	
	@GetMapping("/")
	public List<Cuenta> getCuentas() {
		return cuentaService.getAll();
	}
	
	@GetMapping("/{id}")
	public Cuenta getCuentaById(@PathVariable Long id) {
		return cuentaService.getByID(id);
	}
	
	@PostMapping("/")
	public Cuenta crear () {
		
		
		Cuenta cuenta1= new Cuenta();
		cuenta1.setDescripcion("Cuienta Aliicia");
		cuenta1.setInicio(LocalDate.now());
 
		return cuentaService.crear(cuenta1);
	}
	
	@PutMapping("/{id}")
public Cuenta agregarLineaCuenta (@PathVariable Long id, @RequestBody List<LineaDeCuenta>lineasCuentas) {
		
		/* cuenta= cuentaService.getByID(id);
		
		if(cuenta!=null) {
			
		Producto p1= productoService.getProductoByID(1L);		
		List<LineaDeCuenta>lineas= new ArrayList<>();
		
		LineaDeCuenta linea1= new LineaDeCuenta();
		linea1.setCantidad(2);
		linea1.setFechaRegistro(LocalDate.now());
		linea1.setProducto(p1);
		linea1.setSubTotal(150.00);
;
				
		lineas.add(linea1);
	//	linea1.setCuenta(cuenta)
		cuenta.setLineasCuenta(lineas);
		
		cuentaService.agregarLineaDeCuenta(cuenta, id);
*/
		Producto p1= productoService.getProductoByID(1L);	
		List<LineaDeCuenta>lineas= new ArrayList<>();
		
		LineaDeCuenta linea1= new LineaDeCuenta();
		linea1.setCantidad(2);
		linea1.setFechaRegistro(LocalDate.now());
		linea1.setProducto(p1);
		linea1.setSubTotal(150.00);

				
		lineas.add(linea1);
		return cuentaService.agregarLineaDeCuenta(lineasCuentas, id);
		
		}
	
	@GetMapping("/activa")
	public boolean existeCuentaActiva() {
		return cuentaService.existeCuentaActiva(EstadodeCuenta.activa);
	}
	
	@GetMapping("/fin/{id}")
	public Cuenta finalizarCuenta(@PathVariable Long id) {
		return cuentaService.finalizarCuenta(id);
	}
	
}
