package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulce;

public class TestBuscarProductoNull {
	public static void main(String[] args) {
		MaquinaDulce maquina=new MaquinaDulce();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		
		Producto producto=new Producto("Papitas",0.85, "KE34");
		maquina.cargarProducto(producto, "B1", 4);
		
		Producto prod=maquina.buscarProductoEnCelda("A1");
		System.out.println("Producto encontrado:"+prod.getNombre());
		//el fallo esta en TestBuscarProducto en la linea 15 la variable que ocasona esto es 
		//porque prod.algunMetodo(); se encuentra en null y trato de invocar a un metodo con esa variable
		
		
	}
}
