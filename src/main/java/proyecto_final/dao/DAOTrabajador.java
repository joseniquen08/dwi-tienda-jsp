package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.beans.Trabajador;
import proyecto_final.dto.DTOTrabajadorNuevo;

public class DAOTrabajador extends DAO {
	public List<Trabajador> infoTrabajadores() {
		List <Trabajador> lst = new ArrayList<Trabajador>();
		String sql = "SELECT id, nombre, dni, sede, cargo FROM public.trabajadores;";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Trabajador c = new Trabajador();
				c.setId(rs.getLong(1));
				c.setNombre(rs.getString(2));
				c.setDni(rs.getLong(3));
				c.setSede(rs.getString(4));
				c.setCargo(rs.getString(5));
				lst.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}
	
	public Trabajador obtenerTrabajadorPorID(long id) {
		Trabajador t = null;
	    String sql = "SELECT id, nombre, dni, sede, cargo FROM public.trabajadores WHERE id = ?";
	    Connection cnx = crearCnx();
	    try {
	        PreparedStatement pstm = cnx.prepareStatement(sql);
	        pstm.setLong(1, id);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	        	t = new Trabajador();
	        	t.setId(rs.getLong("id"));
	        	t.setNombre(rs.getString("nombre"));
	        	t.setDni(rs.getLong("dni"));
	        	t.setSede(rs.getString("sede"));
	        	t.setCargo(rs.getString("cargo"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return t;
	}
	
public void insertarTrabajadores(DTOTrabajadorNuevo dto) {
		String sql = "INSERT INTO public.trabajadores(id, nombre, dni, sede, cargo) VALUES (?, ?, ?, ?, ?)";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setLong(1,dto.getId());
			pstm.setString(2,dto.getNombre());
			pstm.setLong(3,dto.getDni());
			pstm.setString(4,dto.getSede());
			pstm.setString(5,dto.getCargo());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void editarTrabajadores(DTOTrabajadorNuevo dto) {
		String sql = "UPDATE public.trabajadores SET nombre=?, dni=?, sede=?, cargo=? WHERE id=?";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setString(1,dto.getNombre());
			pstm.setLong(2,dto.getDni());
			pstm.setString(3,dto.getSede());
			pstm.setString(4,dto.getCargo());
			pstm.setLong(5,dto.getId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
