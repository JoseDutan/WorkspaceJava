package com.krakedev.tes;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.setNombre("Romario");
		p1.setApellido("Meneses");
		
		Direccion dir = new Direccion();
		dir.setCallePrincipal("Av Siempre viva");
		dir.setCalleSecundaria("La que cruza");
		dir.setNumero("N-47");
		
		p1.setDireccion(dir);
		
		String nombre = p1.getNombre();
		Direccion d1 = p1.getDireccion();
		
		System.out.println("Nombre: "+nombre);
		System.out.println(d1.getCallePrincipal());
		p1.imprimir();
		
		Persona p2 = new Persona();
		Direccion d2= new Direccion("AV sryris", "Eloy Alfaro", "S/N");
		p2.setNombre("Anastas");
		p2.setDireccion(d2);
		p2.imprimir();
		
		Persona p3 = new Persona();
		p3.setDireccion(new Direccion("xx", "yy", "123"));
		p3.imprimir();
	}

}
