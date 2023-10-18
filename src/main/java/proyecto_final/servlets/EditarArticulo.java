package proyecto_final.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyecto_final.beans.Articulo;
import proyecto_final.dao.DAOArticulo;
import proyecto_final.dto.DTOArticuloNuevo;
import proyecto_final.services.ServicioGestionArticulos;

/**
 * Servlet implementation class EditarArticulo
 */
@WebServlet(name = "ServletPOSTArticuloEdit", urlPatterns = { "/articulo/ServletPOSTArticuloEdit" })
public class EditarArticulo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ServicioGestionArticulos servicio;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarArticulo() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("idE");
		String strNombre = request.getParameter("nombreE");
		String strTipo = request.getParameter("tipoE");
		String strTalla = request.getParameter("tallaE");
		String strColor = request.getParameter("colorE");
		String strMarca = request.getParameter("marcaE");
		String strPrecio = request.getParameter("precioE");
		String strStock = request.getParameter("stockE");
		
		if (strNombre.isEmpty() && strTipo.isEmpty() && strTalla.isEmpty() && strColor.isEmpty() && strMarca.isEmpty() && strPrecio.isEmpty() && strStock.isEmpty()) {
		    response.sendRedirect("editar.jsp");
		} else {
			
		DTOArticuloNuevo dto = new DTOArticuloNuevo();	
		dto.setId(Long.parseLong(strId));
		
		DAOArticulo dao = new DAOArticulo();
	    Articulo articuloActual = dao.obtenerArticuloPorID(dto.getId());
		
	    if (articuloActual != null) {
	        if (strNombre.isEmpty()) {
	        	dto.setNombre(articuloActual.getNombre());
	        } else {
	        	dto.setNombre(strNombre);
	        }
	        if (strTipo.isEmpty()) {
	        	dto.setTipo(articuloActual.getTipo());
	        } else {
	        	dto.setTipo(strTipo);
	        }
	        if (strTalla.isEmpty()) {
	        	dto.setTalla(articuloActual.getTalla());
	        } else {
	        	dto.setTalla(strTalla);
	        }
	        if (strColor.isEmpty()) {
	        	dto.setColor(articuloActual.getColor());
	        } else {
	        	dto.setColor(strColor);
	        }    
	        if (strMarca.isEmpty()) {
	        	dto.setMarca(articuloActual.getMarca());
		    } else {
		    	dto.setMarca(strMarca);
	        }
	        if (strPrecio.isEmpty()) {
	        	dto.setPrecio(articuloActual.getPrecio());
		    } else {
		    	dto.setPrecio(Double.parseDouble(strPrecio));
	        }
	        if (strStock.isEmpty()) {
	        	dto.setStock(articuloActual.getStock());
		    } else {
		    	dto.setStock(Integer.parseInt(strStock));
	        }
	        servicio.editarArticuloBD(dto);
	    }
	    
		response.sendRedirect("../articulos.jsp");
		}
	}

}
