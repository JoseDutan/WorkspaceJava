package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos;
	private Date fechaModificacion;
	private ArrayList<Contacto> incorrectos = new ArrayList<>();
	private ArrayList<Contacto> correctos = new ArrayList<>();

	public Directorio() {
		this.contactos = new ArrayList<>();
		this.fechaModificacion = new Date();
	}

	public boolean agregarContacto(Contacto contacto) {
		if (buscarPorCedula(contacto.getCedula()) != null) {
            return false;
        }

        contactos.add(contacto);
        fechaModificacion = new Date();
        return true;
	}

	public Contacto buscarPorCedula(String cedula) {
		for (Contacto contacto : contactos) {
			if (contacto.getCedula().equals(cedula)) {
				return contacto;
			}
		}
		return null;
	}
	
	public String consultarUltimaModificacion() {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return formateador.format(fechaModificacion);
    }
	
	public int contarPerdidos() {
        int count = 0;
        for (Contacto contacto : contactos) {
            if (contacto.getDireccion() == null) {
                count++;
            }
        }
        return count;
    }
	
	public int contarFijos() {
		int contador = 0;
		for (Contacto contacto : contactos) {
			for (Telefono telefono : contacto.getTelefonos()) {
				if (telefono.getTipo().equals("Convencional") && telefono.getEstado().equals("C")) {
					contador++;
				}
			}
		}
		return contador;
	}
	
	public void depurar() {
		for (Contacto contacto : contactos) {
			if (contacto.getDireccion() == null) {
				incorrectos.add(contacto);
			} else {
				correctos.add(contacto);
			}
		}
		contactos.clear();
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}
	
}
