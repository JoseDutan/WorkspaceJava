package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;
	
	
	public Telefono(String numero, String tipo) {
		this.numero = numero;
		this.tipo = tipo;
		
		if (validarTelefono(numero, tipo)) {
            estado = "C";
        } else {
            estado = "E";
        }
	}
	
	public String getNumero() {
		return numero;
	}
	public String getTipo() {
		return tipo;
	}
	public String getEstado() {
		return estado;
	}
	
	public boolean validarTelefono(String numero, String tipo) {
        if (numero == null || tipo == null) {
            return false;
        }

        if (!tipo.equals("Movil") && !tipo.equals("Convencional")) {
            return false;
        }

        if (tipo.equals("Movil") && numero.length() != 10) {
            return false;
        }

        if (tipo.equals("Convencional") && numero.length() != 7) {
            return false;
        }

        return true;
    }
}
