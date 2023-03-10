package com.Jo.Cuenta.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jo.Cuenta.Model.Entity.Producto;
import com.Jo.Cuenta.Model.ModelDAO.ProductoDAO;

@Service
public class ProductoServicesImpl implements IProductoService {

	@Autowired
	private ProductoDAO productoDao;
	
	@Override
	public List<Producto> getAllProductos() {
		 
		return productoDao.findAll();
	}

	@Override
	public Producto getProductoByID(Long id) {
		 
		return productoDao.findById(id).orElse(null);
	}

	@Override
	public Producto crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		return productoDao.save(producto);
	}

	@Override
	public Producto updateProducto(Producto producto, Long id) {
		Producto productoACT= productoDao.findById(id).orElse(null);
		
		if(productoACT!=null) {
			productoACT.setNombre(producto.getNombre());
			productoACT.setDescripcion(producto.getDescripcion());	
			productoACT.setCapacidad(producto.getCapacidad());	
			productoACT.setPrecio(producto.getPrecio());	
			productoACT.setLineaGaceosa(producto.getLineaGaceosa());
			productoACT.setImgUrl(producto.getImgUrl());
		}
		
		
		return productoDao.save(productoACT);
	}

	@Override
	public void deleteProducto(Long id) {
		Producto p= productoDao.findById(id).orElse(null);
		productoDao.delete(p);

	}

}
