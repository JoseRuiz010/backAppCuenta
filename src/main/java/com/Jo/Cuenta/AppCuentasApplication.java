package com.Jo.Cuenta;

 
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Jo.Cuenta.Model.Entity.Cuenta;
import com.Jo.Cuenta.Model.Entity.EstadodeCuenta;
import com.Jo.Cuenta.Model.Entity.Producto;
import com.Jo.Cuenta.Service.CuentaServicesImpl;
import com.Jo.Cuenta.Service.ProductoServicesImpl;

 
@SpringBootApplication
public class AppCuentasApplication  {
 

 
	
	public static void main(String[] args) {
		 	
		SpringApplication.run(AppCuentasApplication.class, args);

		}
	@Bean
	CommandLineRunner commandLineRunner(CuentaServicesImpl cuentaService, ProductoServicesImpl productoService) {
		return args->{
			
			Producto p= new Producto();
			p.setDescripcion("Coca cola de 3L");
			p.setNombre("Coca Cola");
			p.setCapacidad("3L");
			p.setPrecio(600D);
			productoService.crearProducto(p);
			
			Producto p1= new Producto();
			p1.setDescripcion("Pepsi de 3L");
			p1.setNombre("Pepsi");
			p1.setCapacidad("3L");
			p1.setPrecio(550D);
			productoService.crearProducto(p1);

			
 			Cuenta c= new Cuenta();
			
			c.setDescripcion("Cuenta de la alicia del mes 02/2023");
			c.setInicio(LocalDate.now());		
			c.setEstado(EstadodeCuenta.activa);
			 
			cuentaService.crear(c);
			 
		 
			
		};
	}

	
	
}
