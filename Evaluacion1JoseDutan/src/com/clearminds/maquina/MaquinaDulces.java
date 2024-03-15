package com.clearminds.maquina;

import java.util.ArrayList;
import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double stock;
	private double saldo;

	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public void agregarCelda(Celda codigoCelda) {
		celdas.add(codigoCelda);
	}

	public void mostrarConfiguracion() {
		Celda celdaEncontrada;
		for (int i = 0; i < celdas.size(); i++) {
			celdaEncontrada = celdas.get(i);
			System.out.println(celdaEncontrada.getCodigo());
		}
	}

	public Celda buscarCelda(String codigo) {
		Celda celdaEncontrada = null;
		Celda elementoCelda = null;
		for (int i = 0; i < celdas.size(); i++) {
			elementoCelda = celdas.get(i);
			if (codigo.equals(elementoCelda.getCodigo())) {
				celdaEncontrada = elementoCelda;
			}
		}
		return celdaEncontrada;
	}

	public void cargarProducto(Producto producto, String codigoCelda, int cantidadInicial) {
		Celda celdaRecuperada = buscarCelda(codigoCelda);
		if (celdaRecuperada != null) {
			celdaRecuperada.ingresarProducto(producto, cantidadInicial);
		}
	}

	public void mostrarProductos() {
		Celda celdaEncontrada;
		for (int i = 0; i < celdas.size(); i++) {
			celdaEncontrada = celdas.get(i);
			if (celdaEncontrada.getProducto() != null) {
				System.out.println("Celda: " + celdaEncontrada.getCodigo() + ", Stock: " + celdaEncontrada.getStock()
						+ ", Producto: " + celdaEncontrada.getProducto().getNombre() + ", Precio: "
						+ celdaEncontrada.getProducto().getPrecio());

			} else {
				System.out.println("Sin Datos");
			}
		}
		System.out.println("Saldo: " + saldo);
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

	public Celda buscarCeldaProducto(String codigoCelda) {
		Celda productoEncontrado = null;
		for (int i = 0; i < celdas.size(); i++) {
			productoEncontrado = celdas.get(i);
			if (productoEncontrado != null && productoEncontrado.getProducto() != null
					&& codigoCelda.equals(productoEncontrado.getProducto().getCodigo())) {
				return productoEncontrado;
			}
		}
		return productoEncontrado;
	}

	public void incrementarProductos(String codigoProducto, int cantidadItemsIncrementar) {
		Celda celdaEncontrada = buscarCeldaProducto(codigoProducto);
		if (celdaEncontrada != null) {
			int unStock = celdaEncontrada.getStock();
			unStock = unStock + cantidadItemsIncrementar;
			celdaEncontrada.setStock(unStock);
		}
	}

	public void vender(String codigoCelda) {
		Celda celdaAVender = buscarCelda(codigoCelda);
		if (celdaAVender != null && celdaAVender.getStock() > 0) {
			Producto s1 = celdaAVender.getProducto();
			double p1 = s1.getPrecio();
			celdaAVender.setStock(celdaAVender.getStock() - 1);
			saldo += p1;
		}
	}

	public double venderConCambio(String codigoCelda, double valorIngresado) {
		double cambio = 0.0;
		Celda celdaEncontrada = buscarCelda(codigoCelda);
		if (celdaEncontrada != null && celdaEncontrada.getStock() > 0) {
			Producto saldo1 = celdaEncontrada.getProducto();
			double precio1 = saldo1.getPrecio();
			if (valorIngresado >= precio1) {
				celdaEncontrada.setStock(celdaEncontrada.getStock() - 1);
				saldo += precio1;
				cambio = valorIngresado - precio1;
				return cambio;
			} else {
				System.out.println("Saldo insuficiente");
				return valorIngresado;
			}
		} else {
			System.out.println("Celda no Encontrada");
			return cambio;
		}
	}
	
	public ArrayList<Producto> buscarMenores(double limite){
		ArrayList<Producto> menores = new ArrayList<Producto>();
		Celda elementoPersona = null;
		Producto productoEncontrado = null;
		for(int i=0;i<celdas.size();i++){
			elementoPersona=celdas.get(i);
			productoEncontrado=elementoPersona.getProducto();
			if(productoEncontrado != null) {
				if(productoEncontrado.getPrecio()<=limite) {
					menores.add(productoEncontrado);
					
				}
			}
		}
		return menores;
	}

}
