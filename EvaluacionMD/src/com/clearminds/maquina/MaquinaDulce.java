package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulce {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public void configurarMaquina(String codigoCelda1, String codigoCelda2, String codigoCelda3, String codigoCelda4) {
		celda1 = new Celda(codigoCelda1);
		celda2 = new Celda(codigoCelda2);
		celda3 = new Celda(codigoCelda3);
		celda4 = new Celda(codigoCelda4);
	}

	public void mostrarConfiguracion() {
		System.out.println("CELDA 1: " + celda1.getCodigo());
		System.out.println("CELDA 2: " + celda2.getCodigo());
		System.out.println("CELDA 3: " + celda3.getCodigo());
		System.out.println("CELDA 4: " + celda4.getCodigo());
	}

	public Celda buscarCelda(String codigoCelda) {
		Celda encontrada = null;
		if (this.celda1.getCodigo().equals(codigoCelda)) {
			encontrada = this.celda1;
		} else if (this.celda2.getCodigo().equals(codigoCelda)) {
			encontrada = this.celda2;
		} else if (this.celda3.getCodigo().equals(codigoCelda)) {
			encontrada = this.celda3;
		} else if (this.celda4.getCodigo().equals(codigoCelda)) {
			encontrada = this.celda4;
		}
		return encontrada;
	}

	public void cargarProducto(Producto producto, String codigoCelda, int cantidadInicial) {
		Celda celdaRecuperada = buscarCelda(codigoCelda);
		if (celdaRecuperada != null) {
			celdaRecuperada.ingresarProducto(producto, cantidadInicial);
		} else {
			System.out.println("Error");
		}
	}

	public void mostrarProductos() {
		System.out.println("CODIGO: " + celda1.getProducto().getCodigo() + ", STOCK: " + celda1.getStock()
		+ ", NOMBRE: " + celda1.getProducto().getNombre() + ", PRECIO: " + celda3.getProducto().getPrecio());
		System.out.println("CODIGO: " + celda2.getCodigo() + ", STOCK: " + celda2.getStock());
		System.out.println("CODIGO: " + celda3.getProducto().getCodigo() + ", STOCK: " + celda3.getStock()
				+ ", NOMBRE: " + celda3.getProducto().getNombre() + ", PRECIO: " + celda3.getProducto().getPrecio());
		System.out.println("CODIGO: " + celda4.getCodigo() + ", STOCK: " + celda4.getStock());
	}

	public Producto buscarProductoEnCelda(String codigoCelda) {
		Celda celdaRecuperada = buscarCelda(codigoCelda);
		Producto productoEncontrado = null;
		if (celdaRecuperada != null) {
			return productoEncontrado = celdaRecuperada.getProducto();
		} else {
			return productoEncontrado;
		}
	}

	public double consultarPrecio(String codigoCelda) {
		Producto productoEncontrado = buscarProductoEnCelda(codigoCelda);
		double precio = 0.0;
		if (productoEncontrado != null) {
			precio = productoEncontrado.getPrecio();
		}
		return precio;
	}

	public Celda buscarCeldaProducto(String codigoProducto) {
		if (celda1 != null && celda1.getProducto() != null && celda1.getProducto().getCodigo().equals(codigoProducto)) {
			return celda1;
		}
		if (celda2 != null && celda2.getProducto() != null && celda2.getProducto().getCodigo().equals(codigoProducto)) {
			return celda2;
		}
		if (celda3 != null && celda3.getProducto() != null && celda3.getProducto().getCodigo().equals(codigoProducto)) {
			return celda3;
		}
		if (celda4 != null && celda4.getProducto() != null && celda4.getProducto().getCodigo().equals(codigoProducto)) {
			return celda4;
		}

		return null;
	}

	public void incrementarProductos(String codigoProducto, int cantidadItemsIncrementar) {
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
		if(celdaEncontrada != null) {
			int unStock = celdaEncontrada.getStock();
			unStock=unStock+cantidadItemsIncrementar;
			celdaEncontrada.setStock(unStock);
		}
		
	}

	public void vender(String codigoCelda) {
		Celda celdaAVender = buscarCelda(codigoCelda);
		if (celdaAVender != null) {
			celdaAVender.getProducto().disminuirPrecio(saldo);
			
			Producto productoVenta = celdaAVender.getProducto();
			double precioVenta = productoVenta.getPrecio();
			this.saldo += precioVenta;
			
			mostrarProductos();
		}
	}
	
	public double venderConCambio(String codigoCelda, double valorIngresado) {
		double cambio = 0.0;
		Celda cambioVender = buscarCelda(codigoCelda);
		if (cambioVender != null) {
			cambioVender.getProducto().disminuirPrecio(saldo);
			
			Producto productoVenta = cambioVender.getProducto();
			double precioVenta = productoVenta.getPrecio();
			cambio = valorIngresado-precioVenta;
			
			this.saldo += precioVenta;
			
			mostrarProductos();
		}
		return cambio;
	}
	
	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
