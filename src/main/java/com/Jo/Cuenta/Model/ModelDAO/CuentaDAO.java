package com.Jo.Cuenta.Model.ModelDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Jo.Cuenta.Model.Entity.Cuenta;
import com.Jo.Cuenta.Model.Entity.EstadodeCuenta;
 

@Repository
public interface CuentaDAO extends JpaRepository<Cuenta, Long> {

//	@Query("select f from Factura f join fetch f.cliente c join fetch f.itemsFacturas l join fetch l.producto where f.id =?1")
	@Query("select cu from Cuenta cu join fetch cu.lineasCuenta lc join lc.producto where cu.id=?1")
	public Cuenta fetchByIdWithClienteWithItemFacturaWhithProducto(Long id);
	 
	boolean existsByEstado(EstadodeCuenta estado) ;

}
