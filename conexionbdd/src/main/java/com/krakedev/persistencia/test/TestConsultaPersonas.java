package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Personas;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaPersonas {

	public static void main(String[] args) {
		try {
			ArrayList<Personas> persona =AdminPersonas.buscarPorNombre("SArrayLitantiago");
			System.out.println(persona);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
