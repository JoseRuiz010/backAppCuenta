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
			p.setImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWDOnSWAsSX8MbWX7fde2c3Tk0oky8D_TKIQ&usqp=CAU");
			productoService.crearProducto(p);
			
			Producto p1= new Producto();
			p1.setDescripcion("Pepsi de 3L");
			p1.setNombre("Pepsi");
			p1.setCapacidad("3L");
			p1.setPrecio(550D);
			p1.setImgUrl("http://d2r9epyceweg5n.cloudfront.net/stores/001/108/127/products/pepsi-ret1-5f7e2ab962f8fb772e15959641943935-640-0.png");
			productoService.crearProducto(p1);
			
			Producto p2= new Producto();
			p2.setDescripcion("Fanta 3L");
			p2.setNombre("Fanta");
			p2.setCapacidad("3L");
			p2.setPrecio(600D);
			p2.setImgUrl("https://masonlineprod.vtexassets.com/arquivos/ids/166476-800-auto?v=637835138574130000&width=800&height=auto&aspect=true");
			productoService.crearProducto(p2);
			
			Producto p3= new Producto();
			p3.setDescripcion("Mirinda 2l");
			p3.setNombre("Mirinda");
			p3.setCapacidad("2L");
			p3.setPrecio(550D);
			p3.setImgUrl("https://m.media-amazon.com/images/I/61A2xyPL6iL._SL1500_.jpg");
			productoService.crearProducto(p3);
			
 			Cuenta c= new Cuenta();
			
			c.setDescripcion("Cuenta de la alicia del mes 02/2023");
			c.setInicio(LocalDate.now());		
			c.setEstado(EstadodeCuenta.activa);
			 
			cuentaService.crear(c);
			 
		 
			
		};
	
	}

	
	
}
