package com.krakedev.persistencia.servicios;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Cuentas;
import com.krakedev.persistencia.entidades.Usuario;
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
	
	public static ArrayList<Cuentas> buscarPorCuenta(String cuenta) throws Exception{
		ArrayList<Cuentas> cuenta1 = new ArrayList<Cuentas>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		Cuentas cu = new Cuentas();
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from cuentas where numero_cuenta = ?");
			ps.setString(1, cuenta);
			rs = ps.executeQuery();
			if(rs.next()) {
				String numero_cuenta=rs.getString("numero_cuenta");
				String cedula_propietario=rs.getString("cedula_propietario");
				Date fecha_creacion=rs.getDate("fecha_creacion");
				BigDecimal saldo=rs.getBigDecimal("saldo");
				cu.setNumero_cuenta(numero_cuenta);
				if(cu.getDni()!=null) {
					cu.getDni().setCedula(cedula_propietario);
				}
				cu.setFecha_creacion(fecha_creacion);
				cu.setSaldo(saldo);
				cuenta1.add(cu);
			} else {
				return null;
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por cuenta", e);
			throw new Exception("Error al consultar por cuenta");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de Datos", e);
				throw new Exception("Error con la base de Datos");
			}
		}
		return cuenta1;
	}
	
	
	public static ArrayList<Usuario> buscarPorCedula(String cedula) throws Exception{
		ArrayList<Usuario> Acedula = new ArrayList<Usuario>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from usuario where nombre like ?");
			ps.setString(1, "%"+cedula+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				String cedula1 = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String tipo_Cuenta = rs.getString("tipo_cuenta");
				BigDecimal limite_credito = rs.getBigDecimal("limite_credito");
				Usuario us= new Usuario();
				us.setNombre(nombre);
				us.setCedula(cedula1);
				us.setApellido(apellido);
				us.setTipo_cuenta(tipo_Cuenta);
				us.setLimite_credito(limite_credito);
				Acedula.add(us);
			}
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error con la base de Datos", e);
				throw new Exception("Error con la base de Datos");
			}
		}
		
		return Acedula;
	}
}
