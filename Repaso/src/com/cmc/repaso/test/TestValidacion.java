package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		Validacion v1 = new Validacion();
		Validacion v2 = new Validacion();
		v1.validarMonto(100);
		v2.validarMonto(0);
	}

}
