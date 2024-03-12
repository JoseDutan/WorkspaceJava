package com.krakedev.controlflujo;

public class Validador {
	public void validarEdad(int edad) {
		if (edad >= 18) {
			System.out.println("Es mayor de edad");
		} else if (edad>=12 && edad<18){
			System.out.println("Es Adolecente");
		} else if (edad>0 && edad<12) {
			System.out.println("Es Niño");
		}else {
			System.out.println("Edad Incorrecta");
		}
	}
}
