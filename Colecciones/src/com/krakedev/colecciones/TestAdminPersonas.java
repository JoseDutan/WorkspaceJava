package com.krakedev.colecciones;

import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		AdminPersonas admin = new AdminPersonas();
		admin.agregar(new Persona("Mario", "Bebedetti", 50));
		admin.agregar(new Persona("Clark", "Kent", 30));
		admin.agregar(new Persona("Bruno", "Diaz", 25));

		admin.imprimir();

		Persona p1 = admin.buscarPorNombre("Clark");
		if (p1 != null) {
			System.out.println("ENCONTRADO: " + p1.getApellido() + " " + p1.getEdad());
		} else {
			System.out.println("No existe la persona con el nombre Jose");
		}

		ArrayList<Persona> personasMayores = admin.buscarMayore(10);
		System.out.println("Mayore: "+personasMayores.size());
	}

}
