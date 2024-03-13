package com.cmc.directorio.entidades;

public class AdminContactos {
	public Contacto buscarMasPesado(Contacto cont1, Contacto cont2) {
		if(cont1.getPeso()>cont2.getPeso()) {
			return cont1;
		}else {
			return cont2;
		}
	}
	
	public boolean compararOperadoras(Contacto cont1, Contacto cont2) {
		if(cont1.getTelefono().getOperadora() == cont2.getTelefono().getOperadora()){
			return true;
		}else {
			return false;
		}
	}
	
	public void activarUsuario(Contacto cont1) {
		if(cont1.getTelefono().getTieneWhatsapp() == true) {
			cont1.setActivo(true);;
		}
	}
}
