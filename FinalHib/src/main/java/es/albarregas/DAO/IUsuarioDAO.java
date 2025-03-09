package es.albarregas.DAO;

import es.albarregas.beans.Usuario;

/**
 *
 * @author sarap
 */
public interface IUsuarioDAO {
    public Usuario comprobarUsuario(String email);
}
