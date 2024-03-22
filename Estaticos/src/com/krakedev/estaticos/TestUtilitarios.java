package com.krakedev.estaticos;

public class TestUtilitarios {
	public static void main(String[] args) {
		boolean resultado=Utilitarios.validarRango(100);
		System.out.println(resultado);
		int radio=10;
		double area=Math.PI*radio;
		System.out.println(area);
	}
}
