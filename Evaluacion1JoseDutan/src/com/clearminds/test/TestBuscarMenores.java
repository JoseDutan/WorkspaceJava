package com.clearminds.test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		MaquinaDulces maquina = new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("A2"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("B2"));
		maquina.agregarCelda(new Celda("C1"));
		maquina.agregarCelda(new Celda("C2"));

		Producto producto1 = new Producto("Papitas", 0.85, "KA11");
		maquina.cargarProducto(producto1, "A1", 4);

		Producto producto2 = new Producto("Doritos", 0.5, "KA12");
		maquina.cargarProducto(producto2, "A2", 7);

		Producto producto3 = new Producto("Takis", 0.25, "KB13");
		maquina.cargarProducto(producto3, "B1", 8);

		Producto producto4 = new Producto("Get", 0.45, "KB14");
		maquina.cargarProducto(producto4, "B2", 2);

		Producto producto5 = new Producto("Cachitos", 0.75, "KC15");
		maquina.cargarProducto(producto5, "C1", 5);

		Producto producto6 = new Producto("Tostitos", 0.55, "KC16");
		maquina.cargarProducto(producto6, "C1", 5);

		ArrayList<Producto> menores = new ArrayList<Producto>();
		Producto lista;
		menores = maquina.buscarMenores(0.50);
		System.out.println("Productos Menores: "+menores.size());
		for (int i = 0; i < menores.size(); i++) {
			lista = menores.get(i);
			if(lista != null) {
				System.out.println("Nombre"+lista.getNombre()+", Precio: "+lista.getPrecio());
			}
		}
	}

}
