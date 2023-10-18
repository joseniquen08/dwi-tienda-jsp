package proyecto_final.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import proyecto_final.dao.DAOTrabajador;
import proyecto_final.dto.DTOTrabajadorNuevo;

/**
 * Session Bean implementation class ServicioGestionTrabajadores
 */
@Stateless
@LocalBean
public class ServicioGestionTrabajadores {

    /**
     * Default constructor. 
     */
    public ServicioGestionTrabajadores() {
    }
    
    public long registrarTrabajadorNuevo(DTOTrabajadorNuevo dto) {
    	System.out.println("REGISTRAR TRABAJADOR NUEVO");
    	DAOTrabajador dao= new DAOTrabajador();
    	dao.insertarTrabajadores(dto);
    	return dto.getId();
    }

    public long editarTrabajadorBD(DTOTrabajadorNuevo dto) {
    	System.out.println("USUARIO ACTUALIZADO");
    	DAOTrabajador dao= new DAOTrabajador();
    	dao.editarTrabajadores(dto);
    	return dto.getId();
    }
}
