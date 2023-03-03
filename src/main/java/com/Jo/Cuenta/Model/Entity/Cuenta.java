package com.Jo.Cuenta.Model.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@NoArgsConstructor
@Setter
@Getter
public class Cuenta implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Descripcion;
	private LocalDate Inicio;
	private LocalDate fin;
	@Enumerated(EnumType.STRING)
	private EstadodeCuenta estado;
	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name ="cuenta_id" )
	private List<LineaDeCuenta> lineasCuenta  ;
	
	@PrePersist
	public void setFechaInicioXDefault() {
		this.Inicio= LocalDate.now();
	}
	
	public void addLineaCuenta(LineaDeCuenta lineac) {
		
		if(this.lineasCuenta==null) {
			this.lineasCuenta= new ArrayList<LineaDeCuenta>();
		}
		this.lineasCuenta.add(lineac);	
	}

	
}
