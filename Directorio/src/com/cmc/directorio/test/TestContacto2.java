package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto2 {

	public static void main(String[] args) {
		Telefono telef = new Telefono("claro", "0987654321", 10);
		Contacto c = new Contacto("Bryan", "Sanchez", telef, 1.60);

		System.out.println("Nombres: " + c.getNombre() + " " + c.getApellido() + " " + c.getTelefono().getOperadora()
				+ " " + c.getTelefono().getNumero());

		Telefono telef1 = new Telefono("movi", "0987654321", 10);
		Contacto c1 = new Contacto("Jose", "Dutan", telef1, 2.60);

		Telefono telef2 = new Telefono("claro", "0987654321", 15);
		Contacto c2 = new Contacto("Ignacio", "Yupa", telef2, 5.60);
		AdminContactos b1 = new AdminContactos();
		AdminContactos o1 = new AdminContactos();

		Contacto buscar = b1.buscarMasPesado(c1, c2);
		boolean comparar = o1.compararOperadoras(c1, c2);


		System.out.println("El mas Pesado es: " + buscar.getNombre() + " " + buscar.getApellido() + ", con el peso de: "
				+ buscar.getPeso() + " ");
		
		System.out.println(comparar);


	}

}
