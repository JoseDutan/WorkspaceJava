package com.krakedev.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int numero) {
        String valor = numero + "";
        if (valor.length() == 1) {
            valor = "0" + valor;
        }
        return valor;
    }

    public static String formatearDia(int dia) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        return dias[dia];
    }
}
