package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	/*public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement  ps=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "2004");
			System.out.println("Conexion exitosa");
			ps=connection.prepareStatement("insert into clientes (cedula,nombre,apellido,edad)"
					+ "			values(?, ?, ?, ?)");
			ps.setString(1, "0302578171");
			ps.setString(2, "Nino");
			ps.setString(3, "Yupa");
			ps.setInt(4, 19);
			ps.executeUpdate();
			System.out.println("Ejecuta Insert");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}*/
	
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement  ps=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "2004");
			System.out.println("Conexion exitosa");
			ps=connection.prepareStatement("insert into cuentas(numero_cuenta,cedula_propietario,fecha_creacion,saldo)"
					+ "values(?, ?, ?, ?)");
			ps.setString(1, "50203");
			ps.setString(2, "03025");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr = "2020/03/22 10:05:04";
			try {
				Date fecha= sdf.parse(fechaStr);
				System.out.println(fecha);
				long fechaMilis=fecha.getTime();
				System.out.println(fechaMilis);
				
				//crea un java.sql.Date, partiendo de un java.util.Date
				java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);
				System.out.println(fechaSQL);
				
				Time timeSQL = new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(3, fechaSQL);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ps.setBigDecimal(4, new BigDecimal(234.57));
			ps.executeUpdate();
			System.out.println("Ejecuta Insert");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
