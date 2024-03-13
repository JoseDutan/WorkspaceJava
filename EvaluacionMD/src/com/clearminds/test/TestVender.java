package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulce;

public class TestVender {

	public static void main(String[] args) {
		MaquinaDulce maquina=new MaquinaDulce();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		
		Producto producto=new Producto("Papitas",0.85, "KE34");
		maquina.cargarProducto(producto, "B1", 4);
		
		Producto producto2=new Producto("Doritos",0.70, "D456");
		maquina.cargarProducto(producto2, "A1", 6);
		
		maquina.vender("A1");
		System.out.println("**************************");
		maquina.vender("B1");
		System.out.println("**************************");
		maquina.mostrarProductos();

	}

}
