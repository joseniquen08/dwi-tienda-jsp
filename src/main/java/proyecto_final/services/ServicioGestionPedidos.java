package proyecto_final.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import proyecto_final.dao.DAOPedido;
import proyecto_final.dto.DTOPedidoNuevo;

/**
 * Session Bean implementation class ServicioGestionPedidos
 */
@Stateless
@LocalBean
public class ServicioGestionPedidos {

    /**
     * Default constructor. 
     */
    public ServicioGestionPedidos() {
    }

    public long registrarPedidoNuevo(DTOPedidoNuevo dto) {
    	DAOPedido dao = new DAOPedido();
    	dao.insertarPedido(dto);
    	return dto.getId();
    }

    public long editarPedidoBD(DTOPedidoNuevo dto) {
    	DAOPedido dao = new DAOPedido();
    	dao.editarPedido(dto);
    	return dto.getId();
    }
}
