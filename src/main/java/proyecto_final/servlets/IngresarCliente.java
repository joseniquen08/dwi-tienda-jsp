package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.dto.DTOClienteNuevo;
import proyecto_final.services.ServicioGestionClientes;

/**
 * Servlet implementation class IngresarCliente
 */
@WebServlet(name = "ServletPOSTClienteNuevo", urlPatterns = { "/cliente/ServletPOSTClienteNuevo" })
public class IngresarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioGestionClientes servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarCliente() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String strNombre = request.getParameter("nombre");
		String strDni = request.getParameter("dni");
		String strDireccion = request.getParameter("direccion");
		String strTelefono = request.getParameter("telefono");
		
		if (strNombre.isEmpty() || strDni.isEmpty() || strDireccion.isEmpty() || strTelefono.isEmpty()) {
			response.sendRedirect("ingresar.jsp");
		} else {
			DTOClienteNuevo dto = new DTOClienteNuevo();
			dto.setId(Long.parseLong(strId));
			dto.setNombre(strNombre);
			dto.setDni(Long.parseLong(strDni));
			dto.setDireccion(strDireccion);
			dto.setTelefono(Long.parseLong(strTelefono));
			servicio.registrarClienteNuevo(dto);
			response.sendRedirect("../clientes.jsp");
		}
	}

}
