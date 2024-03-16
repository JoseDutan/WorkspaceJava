package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas = new ArrayList<>();
	
	

	public Estudiante(String cedula, String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
	}

	public void agregarNota(Nota nuevaNota) {
		int materiaEncontrada = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getMateria().equals(nuevaNota.getMateria())) {
				materiaEncontrada = 1;
				break;
			}
		}
		if (materiaEncontrada == 0 && (nuevaNota.getCalificacion() > 0) && (nuevaNota.getCalificacion() <= 10)) {
			notas.add(nuevaNota);
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {
		int materiaEncontrada = 0;
		for (int i = 0; i < notas.size(); i++) {
			if (notas.get(i).getMateria().equals(codigo)) {
				if (nuevaNota > 0 && nuevaNota <= 10) {
					notas.get(i).setCalificacion(nuevaNota);
				}
				materiaEncontrada = 1;
				break;
			}
		}
		if (materiaEncontrada == 0) {
			System.out.println("No se encontro la materia: " + codigo);
		}
	}

	public double calcularPromedioNotasEstudiante() {
		double sumarNota = 0.0;
		double promedio = 0.0;
		for (int i = 0; i < notas.size(); i++) {
			sumarNota += notas.get(i).getCalificacion();
		}
		promedio=sumarNota / notas.size();
		return promedio;
	}

	public void mostrar() {
		Nota informacion = null;
		for (int i = 0; i < notas.size(); i++) {
			informacion = notas.get(i);
			System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Cedula: " + cedula + ". Materia: "
					+ informacion.getMateria().getNombre() + ", Calificacion: " + informacion.getCalificacion());
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

}
