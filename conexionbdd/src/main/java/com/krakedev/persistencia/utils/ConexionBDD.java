package com.krakedev.persistencia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConexionBDD {
	private final static String DRIVER="org.postgresql.Driver";
	private final static String URL ="jdbc:postgresql://localhost:5432/postgres";
	private final static String USUARIO="postgres";
	private final static String CLAVE="2004";
	private static final Logger LOGGER = LogManager.getLogger(ConexionBDD.class);
	
	public static Connection conectar() throws Exception{
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL, USUARIO, CLAVE);
			LOGGER.debug("Conexion Exitosa");
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error en la Infraestructura", e);
			throw new Exception("Error en la Infraestructura");
		} catch (SQLException e) {
			LOGGER.error("Error al Conectarse, revise usuario y clave", e);
			throw new Exception("Error al Conectarse, revise usuario y clave");
		}
		return connection;
	}
}
