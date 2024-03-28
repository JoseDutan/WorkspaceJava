package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Cuentas;
import com.krakedev.persistencia.servicios.AdminCuentas;

public class TestConsultaCuenta {

	public static void main(String[] args) {
		try {
			ArrayList<Cuentas> cuenta=AdminCuentas.buscarPorCuenta("11112");
			System.out.println(cuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
