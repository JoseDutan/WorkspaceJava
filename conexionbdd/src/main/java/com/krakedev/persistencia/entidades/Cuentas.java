package com.krakedev.persistencia.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class Cuentas {
	private String numero_cuenta;
	private Usuario dni;
	private Date fecha_creacion;
	private BigDecimal saldo;

	public Cuentas() {

	}

	public Cuentas(String numero_cuenta, Usuario dni, Date fecha_creacion, BigDecimal saldo) {
		super();
		this.numero_cuenta = numero_cuenta;
		this.dni = dni;
		this.fecha_creacion = fecha_creacion;
		this.saldo = saldo;
	}
	
	/*public Cuentas(String numero_cuenta, String dni, Date fecha_creacion, BigDecimal saldo) {
		super();
		this.numero_cuenta = numero_cuenta;
		this.dni = dni;
		this.fecha_creacion = fecha_creacion;
		this.saldo = saldo;
	}*/

	public String getNumero_cuenta() {
		return numero_cuenta;
	}

	public void setNumero_cuenta(String numero_cuenta) {
		this.numero_cuenta = numero_cuenta;
	}

	public Usuario getDni() {
		return dni;
	}

	public void setDni(Usuario dni) {
		this.dni = dni;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuentas [numero_cuenta=" + numero_cuenta + ", dni=" + dni + ", fecha_creacion=" + fecha_creacion
				+ ", saldo=" + saldo + "]";
	}

}
