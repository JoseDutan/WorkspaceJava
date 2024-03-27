package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.Cuentas;
import com.krakedev.persistencia.entidades.Usuario;
import com.krakedev.persistencia.servicios.AdminCuentas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizarCuenta {
	public static void main(String[] args) {
		Usuario us = new Usuario("01024", "Pedro", "Suarez", "Ahorros", new BigDecimal(1000.00));
		Cuentas cu = new Cuentas("32984", us, null, new BigDecimal(988.54)); 
		try {
			Date fechaCre = Convertidor.convertirFecha("2022/01/23");
			cu.setFecha_creacion(fechaCre);
			AdminCuentas.actualizar(cu);
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}
	}
}
