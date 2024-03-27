package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Cuentas;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminCuentas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	public static void insertar(Cuentas dni) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar>>> " + dni);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into cuentas (numero_cuenta,cedula_propietario,fecha_creacion,saldo)"
					+ "values(?,?,?,?)");
			ps.setString(1, dni.getNumero_cuenta());
			ps.setString(2, dni.getDni().getCedula());
			ps.setDate(3, new java.sql.Date(dni.getFecha_creacion().getTime()));
			ps.setBigDecimal(4, dni.getSaldo());
			
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
	
	/*public static void insertar(Usuario cedula) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar>>> " + cedula);
		try {
			// abrir la conexion
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("insert into usuario(cedula, nombre, apellido, tipo_cuenta, limite_credito)"
					+ "values(?,?,?,?,?)");
			ps.setString(1, cedula.getCedula().getDni());
			ps.setString(2, cedula.getNombre());
			ps.setString(3, cedula.getApellido());
			ps.setString(4, cedula.getTipo_cuenta());
			ps.setBigDecimal(5, cedula.getLimite_credito());
			
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
	}*/
	
	public static void actualizar(Cuentas dni) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"UPDATE cuentas SET fecha_creacion = ?, saldo = ? WHERE cedula_propietario = ?");
			ps.setDate(1, new java.sql.Date(dni.getFecha_creacion().getTime()));
			ps.setBigDecimal(2, dni.getSaldo());
			ps.setString(3, dni.getDni().getCedula());
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
			ps = con.prepareStatement("DELETE FROM cuentas WHERE cedula_propietario = ?");
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
