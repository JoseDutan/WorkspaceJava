package com.krakedev.estaticos;

public class TestEstaticos {

	public static void main(String[] args) {
		//Para invocar un metodo etatico se lo hace directamente desde la calse
		//no hace falta declarar un objeto
		//el estatico es parte de la clase, no del objeto
		double numero=Math.random();
		System.out.println(numero);
	}

}
