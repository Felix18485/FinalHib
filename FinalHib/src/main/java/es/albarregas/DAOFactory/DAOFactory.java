package es.albarregas.DAOFactory;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.ITutorDAO;
import es.albarregas.DAO.IUsuarioDAO;

/**
 *
 * @author sarap
 */
public abstract class DAOFactory {
    public abstract IGenericoDAO getGenericoDAO();
    public abstract IUsuarioDAO getUsuarioDAO();
    public abstract ITutorDAO getTutorDAO();
    
    /**
     * Fábrica abstracta
     * @return Objeto de la fábrica abstracta
     */
    public static DAOFactory getDAOFactory() {
        
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }
}
