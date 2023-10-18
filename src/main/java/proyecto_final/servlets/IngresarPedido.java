package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.dto.DTOPedidoNuevo;
import proyecto_final.services.ServicioGestionPedidos;

/**
 * Servlet implementation class IngresarPedido
 */
@WebServlet(name = "ServletPOSTPedidoNuevo", urlPatterns = { "/pedido/ServletPOSTPedidoNuevo" })
public class IngresarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioGestionPedidos servicio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarPedido() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String strCantidad = request.getParameter("cantidad");
		String strPedidoCod = request.getParameter("pedidocod");	
		String strTipoarticulo = request.getParameter("tipoarticulo");
		String strTalla = request.getParameter("talla");
		String strColor = request.getParameter("color");
		String strDetalles = request.getParameter("detalles");
		String strSubtotal = request.getParameter("subtotal");

		if (strCantidad.isEmpty() && strPedidoCod.isEmpty() && strTipoarticulo.isEmpty()
				&& strTalla.isEmpty() && strColor.isEmpty() && strDetalles.isEmpty() && strSubtotal.isEmpty()) {
		    response.sendRedirect("ingresar.jsp");
		} else {
			DTOPedidoNuevo dto = new DTOPedidoNuevo();
			dto.setId(Long.parseLong(strId));
			dto.setCantidad(Integer.parseInt(strCantidad));
			dto.setPedidoCod(Long.parseLong(strPedidoCod));
			dto.setTipoArticulo(strTipoarticulo);
			dto.setTalla(strTalla);
			dto.setColor(strColor);
			dto.setDetalles(strDetalles);
			dto.setSubtotal(Double.parseDouble(strSubtotal));
			servicio.registrarPedidoNuevo(dto);
			response.sendRedirect("../pedidos.jsp");
		}
	}

}
