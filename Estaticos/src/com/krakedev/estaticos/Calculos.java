package com.krakedev.estaticos;

public class Calculos {
	//final hace que el valor no se pueda cambiar es 
	//decir convierte la variable en una costante
	//y van todas en mayuscula
	private final double IVA = 12;
	
	public double calcularIva(double monto) {
		return monto*IVA/12;
	}
	
}
