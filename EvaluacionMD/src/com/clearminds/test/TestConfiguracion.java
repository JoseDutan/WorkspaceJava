package com.clearminds.test;

import com.clearminds.maquina.MaquinaDulce;

public class TestConfiguracion {

	public static void main(String[] args) {
		MaquinaDulce maquina=new MaquinaDulce();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		maquina.mostrarConfiguracion();

	}

}
