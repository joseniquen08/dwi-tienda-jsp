package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.beans.Cliente;
import proyecto_final.dao.DAOCliente;
import proyecto_final.dto.DTOClienteNuevo;
import proyecto_final.services.ServicioGestionClientes;

/**
 * Servlet implementation class EditarCliente
 */
@WebServlet(name = "ServletPOSTClienteEdit", urlPatterns = { "/cliente/ServletPOSTClienteEdit" })
public class EditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicioGestionClientes servicio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCliente() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("idE");
		String strNombre = request.getParameter("nombreE");
		String strDni = request.getParameter("dniE");
		String strDireccion = request.getParameter("direccionE");
		String strTelefono = request.getParameter("telefonoE");
		
		if (strNombre.isEmpty()
			&& strDni.isEmpty()
			&& strDireccion.isEmpty()
			&& strTelefono.isEmpty()
		) {
			response.sendRedirect("editar.jsp");
		} else {
			DTOClienteNuevo dto = new DTOClienteNuevo();
			dto.setId(Long.parseLong(strId));
			
			DAOCliente dao = new DAOCliente();
			Cliente clienteActual = dao.obtenerClientePorID(dto.getId());
			
			if (clienteActual != null) {
				if (strNombre.isEmpty()) {
					dto.setNombre(clienteActual.getNombre());
				} else {
					dto.setNombre(strNombre);
				}
				if (strDni.isEmpty()) {
					dto.setDni(clienteActual.getDni());
				} else {
					dto.setDni(Long.parseLong(strDni));
				}
				if (strDireccion.isEmpty()) {
		            dto.setDireccion(clienteActual.getDireccion());
		        } else {
		            dto.setDireccion(strDireccion);
		        }
		        if (strTelefono.isEmpty()) {
		            dto.setTelefono(clienteActual.getTelefono());
		        } else {
		            dto.setTelefono(Long.parseLong(strTelefono));
		        }
		        servicio.editarClienteBD(dto);
			}
			response.sendRedirect("../clientes.jsp");
		}
	}
}
