package com.Jo.Cuenta.Service;

import java.util.List;

 
public interface IGenericService<T> {
	
	public List<T> getAll();
	public T getByID(Long id);
	public T crear(T producto);
	public T update (T producto, Long id);
	public void delete(Long id);
	
}
