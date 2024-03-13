package com.clearminds.componentes;

public class Producto {
	private String nombre;
	  private double precio;
	  private String codigo;
	  
	public Producto(String nombre, double precio, String codigo) {
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}
	
	public void incrementarPrecio(int porcentajeIncremento) {
		double incremento = precio*(porcentajeIncremento*0.01);
		precio += incremento;
	}
	
	public void disminuirPrecio(double descuento) {
		double totalDescuento = precio - descuento;
		precio = totalDescuento;
	}  
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	  
}
