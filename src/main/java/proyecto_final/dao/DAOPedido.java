package proyecto_final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import proyecto_final.beans.PedidoArticulo;
import proyecto_final.beans.PedidoNuevoArticulo;
import proyecto_final.dto.DTOPedidoNuevo;

public class DAOPedido extends DAO{
	public List<PedidoArticulo> infoPedidosArticulo() {
		List<PedidoArticulo> lst = new ArrayList<PedidoArticulo>();
		String sql = "SELECT id, cantidad, pedido_cod, articulo_id FROM public.pedido_articulo";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				PedidoArticulo p = new PedidoArticulo();
				p.setId(rs.getLong(1));
				p.setCantidad(rs.getInt(2));
				p.setPedidoCod(rs.getLong(3));
				p.setArticuloId(rs.getLong(4));
				lst.add(p);
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
	
	public List<PedidoNuevoArticulo> infoPedidosNuevoArticulo() {
		List <PedidoNuevoArticulo> lst = new ArrayList<PedidoNuevoArticulo>();
		String sql = "SELECT id, cantidad, pedido_cod, tipo_articulo, talla, color, detalles, subtotal FROM public.pedido_nuevo_articulo";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				PedidoNuevoArticulo n = new PedidoNuevoArticulo();
				n.setId(rs.getLong(1));
				n.setCantidad(rs.getInt(2));
				n.setPedidoCod(rs.getLong(3));
				n.setTipoArticulo(rs.getString(4));
				n.setTalla(rs.getString(5));
				n.setColor(rs.getString(6));
				n.setDetalles(rs.getString(7));
				n.setSubtotal(rs.getDouble(8));
				lst.add(n);
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
	
	public PedidoNuevoArticulo obtenerPedidoPorID(long id) {
		PedidoNuevoArticulo p = null;
	    String sql = "SELECT id, cantidad, pedido_cod, tipo_articulo, talla, color, detalles, subtotal\r\n"
	    		+ "	FROM public.pedido_nuevo_articulo WHERE id = ?";
	    Connection cnx = crearCnx();
	    try {
	        PreparedStatement pstm = cnx.prepareStatement(sql);
	        pstm.setLong(1, id);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	            p = new PedidoNuevoArticulo();
	            p.setId(rs.getLong("id"));
	            p.setCantidad(rs.getInt("cantidad"));
	            p.setPedidoCod(rs.getLong("pedidocod"));
	            p.setTipoArticulo(rs.getString("tipoarticulo"));
	            p.setTalla(rs.getString("talla"));
	            p.setColor(rs.getString("color"));
	            p.setDetalles(rs.getString("detalles"));
	            p.setSubtotal(rs.getDouble("subtotal"));
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
	    return p;
	}
	
	public void insertarPedido(DTOPedidoNuevo dto) {
		String sql = "INSERT INTO public.pedido_nuevo_articulo(\r\n"
				+ "	id, cantidad, pedido_cod, tipo_articulo, talla, color, detalles, subtotal)\r\n"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);
			pstm.setLong(1,dto.getId());
			pstm.setInt(2,dto.getCantidad());
			pstm.setLong(3,dto.getPedidoCod());
			pstm.setString(4,dto.getTipoArticulo());
			pstm.setString(5,dto.getTalla());
			pstm.setString(6,dto.getColor());
			pstm.setString(7,dto.getDetalles());
			pstm.setDouble(8,dto.getSubtotal());			
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
	
	public void editarPedido(DTOPedidoNuevo dto) {
		String sql = "UPDATE public.pedido_nuevo_articulo SET \r\n"
				+ "	cantidad=?, pedido_cod=?, tipo_articulo=?, talla=?, color=?, detalles=?, subtotal=?\r\n"
				+ "	WHERE id = ?";
		Connection cnx = crearCnx();
		try {
			PreparedStatement pstm = cnx.prepareStatement(sql);			
			pstm.setInt(1,dto.getCantidad());
			pstm.setLong(2,dto.getPedidoCod());
			pstm.setString(3,dto.getTipoArticulo());
			pstm.setString(4,dto.getTalla());
			pstm.setString(5,dto.getColor());
			pstm.setString(6,dto.getDetalles());
			pstm.setDouble(7,dto.getSubtotal());
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
