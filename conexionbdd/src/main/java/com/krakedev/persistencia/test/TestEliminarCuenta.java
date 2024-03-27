package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminCuentas;

public class TestEliminarCuenta {
	public static void main(String[] args) {
		try {
			AdminCuentas.eliminar("03025");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
