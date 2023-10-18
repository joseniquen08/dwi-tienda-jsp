package proyecto_final.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import proyecto_final.dao.DAOArticulo;
import proyecto_final.dto.DTOArticuloNuevo;

/**
 * Session Bean implementation class ServicioGestionArticulo
 */
@Stateless
@LocalBean
public class ServicioGestionArticulos {

    /**
     * Default constructor. 
     */
    public ServicioGestionArticulos() {
    }

    public long registrarArticuloNuevo(DTOArticuloNuevo dto) {
    	DAOArticulo dao = new DAOArticulo();
    	dao.insertarArticulo(dto);
    	return dto.getId();
    }
    
    public long editarArticuloBD(DTOArticuloNuevo dto) {
    	DAOArticulo dao = new DAOArticulo();
    	dao.editarArticulo(dto);
    	return dto.getId();
    }
}
