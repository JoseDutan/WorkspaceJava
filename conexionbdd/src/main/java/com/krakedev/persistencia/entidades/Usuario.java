package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;

public class Usuario {
	private String cedula;
	private String nombre;
	private String apellido;
	private String tipo_cuenta;
	private BigDecimal limite_credito;
	
	public Usuario() {
		
	}
	
	public Usuario(String cedula, String nombre, String apellido, String tipo_cuenta, BigDecimal limite_credito) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_cuenta = tipo_cuenta;
		this.limite_credito = limite_credito;
	}
	
	/*public Usuario(Cuentas cedula, String nombre, String apellido, String tipo_cuenta, BigDecimal limite_credito) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipo_cuenta = tipo_cuenta;
		this.limite_credito = limite_credito;
	}*/

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	public BigDecimal getLimite_credito() {
		return limite_credito;
	}

	public void setLimite_credito(BigDecimal limite_credito) {
		this.limite_credito = limite_credito;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", tipo_cuenta="
				+ tipo_cuenta + ", limite_credito=" + limite_credito + "]";
	}
	
	
}
