package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulce;


public class TestCargarProducto {
	public static void main(String[] args) {
		MaquinaDulce maquina=new MaquinaDulce();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		
		Producto producto=new Producto("Papitas",0.85, "KE34");
		maquina.cargarProducto(producto, "B1", 4);
		
		maquina.mostrarProductos();
	}
}