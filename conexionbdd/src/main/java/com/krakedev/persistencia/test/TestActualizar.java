package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Personas;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		Personas p= new Personas("0302578165", "Bryan", "Dutan", 1.70, null, null, new BigDecimal(857.54), 5, new EstadoCivil("S", "Soltero"));
		try {
			Date fechaNac=Convertidor.convertirFecha("2004/07/04");
			Date horaNac=Convertidor.convertirHora("20:35");
			p.setFecha_nacimiento(fechaNac);
			p.setHora_nacimiento(horaNac);
			AdminPersonas.actualizar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: "+e.getMessage());
		}

	}

}
