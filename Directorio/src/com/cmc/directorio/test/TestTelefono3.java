package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono3 {

	public static void main(String[] args) {
		int mensaje;
		Telefono telf1 = new Telefono("movi", "0912345678", 12);
		Telefono telf2 = new Telefono("claro","0998305731", 15);
		Telefono telf3 = new Telefono("movi","0137456435", 17);
		AdminTelefono at =new AdminTelefono();
		mensaje = at.contarMovil(telf1, telf2, telf3);
		
		System.out.println(mensaje);

	}

}
