package es.albarregas.DAO;

import es.albarregas.beans.Usuario;

/**
 *
 * @author sarap
 */
public class UsuarioDAO extends GenericoDAO<Usuario> implements IUsuarioDAO {

    @Override
    public Usuario comprobarUsuario(String email) {
        Usuario usuario = null;
        startTransaction();
        String hql = "SELECT u FROM Usuario u WHERE u.email = :email";
        usuario = (Usuario) sesion.createQuery(hql).setParameter("email", email).uniqueResult();
        endTransaction();
        return usuario;
    }

}
