package proyecto_final.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import proyecto_final.dao.DAOCliente;
import proyecto_final.dto.DTOClienteNuevo;

/**
 * Session Bean implementation class ServicioGestionClientes
 */
@Stateless
@LocalBean
public class ServicioGestionClientes {

    /**
     * Default constructor. 
     */
    public ServicioGestionClientes() {
    }
    
    public long registrarClienteNuevo(DTOClienteNuevo dto) {
    	DAOCliente dao = new DAOCliente();
    	dao.insertarCliente(dto);
    	return dto.getId();
    }
    
    public long editarClienteBD(DTOClienteNuevo dto) {
    	DAOCliente dao= new DAOCliente();
    	dao.editarCliente(dto);
    	return dto.getId();
    }
}
