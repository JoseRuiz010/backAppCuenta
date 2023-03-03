package com.Jo.Cuenta.Service;

import java.util.List;

import com.Jo.Cuenta.Model.Entity.Producto;

public interface IProductoService {

	public List<Producto> getAllProductos();
	public Producto getProductoByID(Long id);
	public Producto crearProducto(Producto producto);
	public Producto updateProducto (Producto producto, Long id);
	public void deleteProducto(Long id);
}
