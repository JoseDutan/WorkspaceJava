package com.krakedev.herencia;

public class Perro extends Animal{
	public Perro() {
		super();
		System.out.println("Ejecuta constructor de Perro");
	}
	
	public void ladrar() {
		System.out.println("Perro Ladrando");
	}
	
	@Override
	public void dormir() {
		super.dormir();
		System.out.println("Perro Durmiendo");
	}
}
