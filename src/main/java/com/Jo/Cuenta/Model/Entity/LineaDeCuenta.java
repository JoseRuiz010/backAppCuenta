package com.Jo.Cuenta.Model.Entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

 

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "lineaCuenta")
public class LineaDeCuenta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate fechaRegistro;
	private int cantidad;
	@ManyToOne(fetch = FetchType.EAGER)
	private Producto producto;
	
	private Double subTotal;
	
	
	 
	
	
	@PrePersist
	private void setFecharegistro() {
		this.fechaRegistro= LocalDate.now();
		this.subTotal= producto.getPrecio()*this.cantidad;
	}

	public LineaDeCuenta(LocalDate fechaRegistro, int cantidad, Producto producto) {
		super();
		this.fechaRegistro = fechaRegistro;
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	

}
