package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.beans.Cliente;
import proyecto_final.dto.DTOClienteNuevo;

public class DAOCliente extends DAO {
	public List<Cliente> infoClientes() {
		List<Cliente> lst = new ArrayList<Cliente>();
		String sql = "SELECT id, nombre, dni, direccion, telefono FROM public.clientes";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong(1));
				c.setNombre(rs.getString(2));
				c.setDni(rs.getLong(3));
				c.setDireccion(rs.getString(4));
				c.setTelefono(rs.getLong(5));
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
	
	public Cliente obtenerClientePorID(long id) {
	    Cliente c = null;
	    String sql = "SELECT id, nombre, dni, direccion, telefono FROM public.clientes WHERE id = ?";
	    Connection cnx = crearCnx();
	    try {
	        PreparedStatement pstm = cnx.prepareStatement(sql);
	        pstm.setLong(1, id);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	            c = new Cliente();
	            c.setId(rs.getLong(1));
	            c.setNombre(rs.getString(2));
	            c.setDni(rs.getLong(3));
	            c.setDireccion(rs.getString(4));
	            c.setTelefono(rs.getLong(5));
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
	    return c;
	}
	
	public void insertarCliente(DTOClienteNuevo dto) {
		String sql = "INSERT INTO public.clientes(id, nombre, dni, direccion,telefono) VALUES (?, ?, ?, ?, ?)";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setLong(1,dto.getId());
			pstm.setString(2,dto.getNombre());
			pstm.setLong(3,dto.getDni());
			pstm.setString(4,dto.getDireccion());
			pstm.setLong(5,dto.getTelefono());
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
	
	public void editarCliente(DTOClienteNuevo dto) {
		String sql = "UPDATE public.clientes SET nombre = ?, dni = ?, direccion = ?, telefono = ? WHERE id = ?";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setString(1,dto.getNombre());
			pstm.setLong(2,dto.getDni());
			pstm.setString(3,dto.getDireccion());
			pstm.setLong(4,dto.getTelefono());
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
