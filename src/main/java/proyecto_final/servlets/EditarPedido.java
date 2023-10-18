package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.beans.PedidoNuevoArticulo;
import proyecto_final.dao.DAOPedido;
import proyecto_final.dto.DTOPedidoNuevo;
import proyecto_final.services.ServicioGestionPedidos;

/**
 * Servlet implementation class EditarPedido
 */
@WebServlet(name = "ServletPOSTPedidoEdit", urlPatterns = { "/pedido/ServletPOSTPedidoEdit" })
public class EditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioGestionPedidos servicio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPedido() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("idE");
		String strCantidad = request.getParameter("cantidadE");
		String strPedidoCod = request.getParameter("pedidocodE");	
		String strTipoarticulo = request.getParameter("tipoarticuloE");
		String strTalla = request.getParameter("tallaE");
		String strColor = request.getParameter("colorE");
		String strDetalles = request.getParameter("detallesE");
		String strSubtotal = request.getParameter("subtotalE");

		if (strCantidad.isEmpty() && strPedidoCod.isEmpty() && strTipoarticulo.isEmpty()
				&& strTalla.isEmpty() && strColor.isEmpty() && strDetalles.isEmpty() && strSubtotal.isEmpty()) {
		    response.sendRedirect("editar.jsp");
		} else {
			DTOPedidoNuevo dto = new DTOPedidoNuevo();
			dto.setId(Long.parseLong(strId));
			DAOPedido dao = new DAOPedido();
			PedidoNuevoArticulo pedidoActual = dao.obtenerPedidoPorID(dto.getId());
			if (pedidoActual != null) {
		        if (strCantidad.isEmpty()) {
		        	dto.setCantidad(pedidoActual.getCantidad());
		        } else {
		        	dto.setCantidad(Integer.parseInt(strCantidad));
	        	}
		        if (strPedidoCod.isEmpty()) {
		        	dto.setPedidoCod(pedidoActual.getPedidoCod());
		        } else {
		        	dto.setPedidoCod(Long.parseLong(strPedidoCod));
	        	}
		        if (strTipoarticulo.isEmpty()) {
		        	dto.setTipoArticulo(pedidoActual.getTipoArticulo());
		        } else {
		        	dto.setTipoArticulo(strTipoarticulo);
	        	}
		        if (strTalla.isEmpty()) {
		        	dto.setTalla(pedidoActual.getTalla());
		        } else {
		        	dto.setTalla(strTalla);
	        	}
		        if (strColor.isEmpty()) {
		        	dto.setColor(pedidoActual.getColor());
		        } else {
		        	dto.setColor(strColor);
	        	}
		        if (strDetalles.isEmpty()) {
		        	dto.setDetalles(pedidoActual.getDetalles());
		        } else {
		        	dto.setDetalles(strDetalles);
	        	}
		        if (strSubtotal.isEmpty()) {
		        	dto.setSubtotal(pedidoActual.getSubtotal());
		        } else {
		        	dto.setSubtotal(Double.parseDouble(strSubtotal));
	        	}
		        servicio.editarPedidoBD(dto);
			}
			response.sendRedirect("../pedidos.jsp");
		}
	}

}
