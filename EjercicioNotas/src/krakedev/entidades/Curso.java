package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiante = new ArrayList<>();
	

	public ArrayList<Estudiante> getEstudiante() {
		return estudiante;
	}

	public String buscarEstudiantePorCedula(Estudiante estudiantes) {
		String mensaje=null;
		if(estudiante.size()>0) {
			for(Estudiante buscarEstudiantes: estudiante) {
				if(buscarEstudiantes.getCedula().equals(estudiantes.getCedula())) {
					mensaje="Ya existe un estuidante";
				}
			}
		}
		return mensaje;
	}

	public void matricularEstudiantes(Estudiante estudiantes) {
		String mensaje = buscarEstudiantePorCedula(estudiantes);
		if(mensaje==null) {
			estudiante.add(estudiantes);
		} else {
			System.out.println(mensaje);
		}
		
	}

	public double calcularPromedioCurso() {
		double total = 0.0;
		for(Estudiante estudiante1 :estudiante) {
			total += estudiante1.calcularPromedioNotasEstudiante();
		}
		return total / estudiante.size();
	}
	
	public void mostrar() {
		for (Estudiante informacion :estudiante) {
			informacion.mostrar();
		}
		
	}
}
