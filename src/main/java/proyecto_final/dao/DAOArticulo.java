package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.beans.Articulo;
import proyecto_final.dto.DTOArticuloNuevo;

public class DAOArticulo extends DAO {
	public List<Articulo> infoArticulo() {
		List<Articulo> lst = new ArrayList<Articulo>();
		String sql = "SELECT id, nombre, tipo, talla, color, marca, precio, stock FROM public.articulos;";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Articulo a = new Articulo();
				a.setId(rs.getLong(1));
				a.setNombre(rs.getString(2));
				a.setTipo(rs.getString(3));
				a.setTalla(rs.getString(4));
				a.setColor(rs.getString(5));
				a.setMarca(rs.getString(6));
				a.setPrecio(rs.getDouble(7));
				a.setStock(rs.getInt(8));
				lst.add(a);
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
	
	public Articulo obtenerArticuloPorID(long id) {
	    Articulo a = null;
	    String sql = "SELECT id, nombre, tipo, talla, color, marca, precio, stock FROM public.articulos WHERE id = ?";
	    Connection cnx = crearCnx();
	    try {
	        PreparedStatement pstm = cnx.prepareStatement(sql);
	        pstm.setLong(1, id);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	            a = new Articulo();
	            a.setId(rs.getLong("id"));
	            a.setNombre(rs.getString("nombre"));
	            a.setTipo(rs.getString("tipo"));
	            a.setTalla(rs.getString("talla"));
	            a.setColor(rs.getString("color"));
	            a.setMarca(rs.getString("marca"));
	            a.setPrecio(rs.getDouble("precio"));
	            a.setStock(rs.getInt("stock"));
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
	    return a;
	}
	
	public void insertarArticulo(DTOArticuloNuevo dto) {
		String sql = "INSERT INTO public.articulos(id, nombre, tipo, talla, color, marca, precio, stock) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setLong(1,dto.getId());
			pstm.setString(2,dto.getNombre());
			pstm.setString(3,dto.getTipo());
			pstm.setString(4,dto.getTalla());
			pstm.setString(5,dto.getColor());
			pstm.setString(6,dto.getMarca());
			pstm.setDouble(7,dto.getPrecio());
			pstm.setInt(8,dto.getStock());
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
	
	public void editarArticulo(DTOArticuloNuevo dto) {
		String sql = "UPDATE public.articulos SET nombre=?, tipo=?, talla=?, color=?, marca=?, precio=?, stock=? WHERE id=?";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setString(1,dto.getNombre());
			pstm.setString(2,dto.getTipo());
			pstm.setString(3,dto.getTalla());
			pstm.setString(4,dto.getColor());
			pstm.setString(5,dto.getMarca());
			pstm.setDouble(6,dto.getPrecio());
			pstm.setInt(7,dto.getStock());
			pstm.setLong(8,dto.getId());
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