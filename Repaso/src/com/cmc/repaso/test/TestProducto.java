package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto p1 = new Producto("Papas", 100);
		p1.setPrecio(200);
		
		System.out.println(p1.calcularPrecioPromo(0.75));

	}

}
