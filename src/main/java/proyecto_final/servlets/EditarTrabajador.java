package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.beans.Trabajador;
import proyecto_final.dao.DAOTrabajador;
import proyecto_final.dto.DTOTrabajadorNuevo;
import proyecto_final.services.ServicioGestionTrabajadores;

/**
 * Servlet implementation class EditarTrabajador
 */
@WebServlet(name = "ServletPOSTTrabajadorEdit", urlPatterns = { "/trabajador/ServletPOSTTrabajadorEdit" })
public class EditarTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioGestionTrabajadores servicio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarTrabajador() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("idE");
		String strNombre = request.getParameter("nombreE");
		String strDni = request.getParameter("dniE");
		String strSede = request.getParameter("sedeE");
		String strCargo = request.getParameter("cargoE");
		
		if (strNombre.isEmpty() && strDni.isEmpty() && strSede.isEmpty() && strCargo.isEmpty()) {
		    response.sendRedirect("editar.jsp");
		} else {
			DTOTrabajadorNuevo dto = new DTOTrabajadorNuevo();	
			dto.setId(Long.parseLong(strId));
			DAOTrabajador daoTrabajador = new DAOTrabajador();
		    Trabajador trabActual = daoTrabajador.obtenerTrabajadorPorID(dto.getId());
		    if (trabActual != null) {
		        if (strNombre.isEmpty()) {
		        	dto.setNombre(trabActual.getNombre());
		        } else {
		        	dto.setNombre(strNombre);
		        }
		        if (strDni.isEmpty()) {
		        	dto.setDni(trabActual.getDni());
		        } else {
		        	dto.setDni(Long.parseLong(strDni));
		        }
		        if (strSede.isEmpty()) {
		        	dto.setSede(trabActual.getSede());
		        } else {
		        	dto.setSede(strSede);
		        }
		        if (strCargo.isEmpty()) {
		        	dto.setCargo(trabActual.getCargo());
		        } else {
		        	dto.setCargo(strCargo);
		        }
		        servicio.editarTrabajadorBD(dto);
		    }
			response.sendRedirect("../trabajadores.jsp");
		}
	}
}
