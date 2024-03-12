package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		Item i1 = new Item();
		Item i2 = new Item();
		
		i1.setProductosActuales(20);
		i1.vender(5);
		i1.devolver(10);
		i1.imprimir();
		
		i2.setProductosActuales(45);
		i2.vender(15);
		i2.devolver(5);
		i2.imprimir();
	}

}
