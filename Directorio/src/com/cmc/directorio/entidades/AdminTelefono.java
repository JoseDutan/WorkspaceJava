package com.cmc.directorio.entidades;

public class AdminTelefono {
	public void activarMensajeria(Telefono telef1) {
		if(telef1.getOperadora().equals("movi")) {
			telef1.setTieneWhatsapp(true);
		}
	}
	
	public int contarMovil(Telefono telef1, Telefono telef2, Telefono telef3) {
		int contador=0;
		if(telef1.getOperadora().equals("movi")) {
			contador++;
		}
		if (telef2.getOperadora().equals("movi")) {
			contador++;
		}
		if (telef3.getOperadora().equals("movi")) {
			contador++;
		}
		return contador;
		
	}
}
