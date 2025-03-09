package es.albarregas.DAOFactory;

import es.albarregas.DAO.GenericoDAO;
import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.ITutorDAO;
import es.albarregas.DAO.IUsuarioDAO;
import es.albarregas.DAO.TutorDAO;
import es.albarregas.DAO.UsuarioDAO;


/**
 *
 * @author sarap
 */
public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

    @Override
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }

    @Override
    public ITutorDAO getTutorDAO() {
        return new TutorDAO();
    }
    
}
