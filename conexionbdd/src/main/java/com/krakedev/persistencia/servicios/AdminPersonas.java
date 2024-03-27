package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Personas;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);

	public static void insertar(Personas persona) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar>>> " + persona);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into personas1(cedula, nombre, apellido, fecha_nacimiento, estado_civil)"
					+ "values(?, ?, ?, ?, ?)");
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setDate(4, new java.sql.Date(persona.getFecha_nacimiento().getTime()));
			ps.setString(5, persona.getEstado_civil().getCodigo());

			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de Datos", e);
				throw new Exception("Error con la base de Datos");
			}
		}
	}

	public static void actualizar(Personas persona) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"UPDATE personas1 SET nombre = ?, apellido = ?, estatura = ?, fecha_nacimiento = ?, hora_nacimiento = ?, cantidad_ahorrada = ?, numero_hijos = ?, estado_civil = ? WHERE cedula = ?;");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setDouble(3, persona.getEstatura());
			ps.setDate(4, new java.sql.Date(persona.getFecha_nacimiento().getTime()));
			ps.setTime(5, new java.sql.Time(persona.getHora_nacimiento().getTime()));
			ps.setBigDecimal(6, persona.getCantidad_ahorrada());
			ps.setInt(7, persona.getNumero_hijos());
			ps.setString(8, persona.getEstado_civil().getCodigo());
			ps.setString(9, persona.getCedula());
			
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al actualizar", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de Datos", e);
				throw new Exception("Error con la base de Datos");
			}
		}
	}
	
	public static void eliminar(String cedula) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("DELETE FROM personas1 WHERE cedula = ?");
			ps.setString(1, cedula);
			ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
		} finally {
			try {
				con.close();
			} catch(SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
			
		}
	}
}
