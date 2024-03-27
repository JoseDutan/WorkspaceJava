package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Personas;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

//System.out.println() solo se va a poder usar en los test
public class TestAdminPersona {

	public static void main(String[] args) {
		EstadoCivil ec = new EstadoCivil("U", "Union Libre");
		Personas p = new Personas("0302578165", "Nino", "Dutan", null, ec);
		try {
			Date fechaNac = Convertidor.convertirFecha("2004/07/04");
			p.setFecha_nacimiento(fechaNac);
			AdminPersonas.insertar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}

	}

}
