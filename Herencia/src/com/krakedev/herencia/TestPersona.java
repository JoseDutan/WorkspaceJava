package com.krakedev.herencia;

public class TestPersona {

	public static void main(String[] args) {
		Persona p = new Persona("0998305731", "Julia");
		System.out.println("hola");
		System.out.println(p);//implicitamente realiza un p.toString
		System.out.println(p.toString());
	}

}
