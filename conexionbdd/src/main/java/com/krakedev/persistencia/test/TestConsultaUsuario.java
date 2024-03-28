package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Usuario;
import com.krakedev.persistencia.servicios.AdminCuentas;

public class TestConsultaUsuario {
	public static void main(String[] args) {
		try {
			ArrayList<Usuario> cuenta=AdminCuentas.buscarPorCedula("s");
			System.out.println(cuenta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
