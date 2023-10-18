package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.dto.DTOTrabajadorNuevo;
import proyecto_final.services.ServicioGestionTrabajadores;

/**
 * Servlet implementation class IngresarTrabajador
 */
@WebServlet(name = "ServletPOSTTrabajadorNuevo", urlPatterns = { "/trabajador/ServletPOSTTrabajadorNuevo" })
public class IngresarTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioGestionTrabajadores servicio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarTrabajador() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		String strNombre = request.getParameter("nombre");
		String strDni = request.getParameter("dni");
		String strSede = request.getParameter("sede");
		String strCargo=request.getParameter("cargo");
		if (strNombre.isEmpty()  || strDni.isEmpty() || strSede.isEmpty() || strCargo.isEmpty()) {
		    response.sendRedirect("ingresar.jsp");
		} else {
			DTOTrabajadorNuevo dto = new DTOTrabajadorNuevo();
			dto.setId(Long.parseLong(strId));
			dto.setNombre(strNombre);
			dto.setDni(Long.parseLong(strDni));
			dto.setSede(strSede);
			dto.setCargo(strCargo);
			servicio.registrarTrabajadorNuevo(dto);
			response.sendRedirect("../trabajadores.jsp");
		}
	}

}
