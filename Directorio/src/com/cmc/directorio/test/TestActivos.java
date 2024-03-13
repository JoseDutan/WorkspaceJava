package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		Telefono telef1 = new Telefono("movi", "0987654321", 10);
		Contacto c1 = new Contacto("Jose", "Dutan", telef1, 2.60);

		AdminContactos a1 = new AdminContactos();
		a1.activarUsuario(c1);
		System.out.println(c1.getTelefono().getTieneWhatsapp());

	}

}
