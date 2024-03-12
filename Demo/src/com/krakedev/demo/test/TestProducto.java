package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		Producto p1=new Producto(1445, "Harina");
		p1.setDescripcion("Harina para realizar pan");
		p1.setPeso(1.5);
		
		System.out.println(p1.getCodigo());
		System.out.println(p1.getNombre());
		System.out.println(p1.getDescripcion());
		System.out.println(p1.getPeso());

	}

}
