package com.krakedev.excepciones;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {
	public void metodo1() {
		String a = null;
		a.substring(0);
		//exixten 2 tipode exepciones en esta esta el NPE tipo Unchecked
	}

	public void metodo2() {

		File f = new File("archivo1.txt");
		try {
			f.createNewFile(); //IOException tipo CHECKED
		} catch (IOException io) {
			System.out.println("error");
		}
	}
	
	public void metodo3() throws IOException {

		File f = new File("archivo1.txt");
		f.createNewFile(); //IOException tipo CHECKED
	}
	
	public void metodo4() {

		try {
			metodo3();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
