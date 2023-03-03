package com.Jo.Cuenta.Model.ModelDAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Jo.Cuenta.Model.Entity.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
