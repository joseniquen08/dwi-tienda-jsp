package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.dto.DTOArticuloNuevo;
import proyecto_final.services.ServicioGestionArticulos;

/**
 * Servlet implementation class IngresarArticulo
 */
@WebServlet(name = "ServletPOSTArticuloNuevo", urlPatterns = { "/articulo/ServletPOSTArticuloNuevo" })
public class IngresarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioGestionArticulos servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarArticulo() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String strNombre = request.getParameter("nombre");
		String strTipo = request.getParameter("tipo");
		String strTalla = request.getParameter("talla");
		String strColor = request.getParameter("color");
		String strMarca = request.getParameter("marca");
		String strPrecio = request.getParameter("precio");
		String strStock = request.getParameter("stock");
		
		if (strNombre.isEmpty()  || strTipo.isEmpty() || strTalla.isEmpty() || strColor.isEmpty() || strMarca.isEmpty() || strPrecio.isEmpty() || strStock.isEmpty()) {
			response.sendRedirect("ingresar.jsp");
		} else {
			DTOArticuloNuevo dto = new DTOArticuloNuevo();
			dto.setId(Long.parseLong(strId));
			dto.setNombre(strNombre);
			dto.setTipo(strTipo);
			dto.setTalla(strTalla);
			dto.setColor(strColor);
			dto.setMarca(strMarca);
			dto.setPrecio(Double.parseDouble(strPrecio));
			dto.setStock(Integer.parseInt(strStock));
			servicio.registrarArticuloNuevo(dto);
			response.sendRedirect("../articulos.jsp");
		}
	}
}
