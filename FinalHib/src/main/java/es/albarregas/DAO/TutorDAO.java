package es.albarregas.DAO;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import java.util.List;

/**
 *
 * @author sarap
 */
public class TutorDAO extends GenericoDAO<Tutor> implements ITutorDAO {

    @Override
    public Tutor comprobarTutorCiclo(String idCiclo) {
        Tutor tutor = null;
        startTransaction();
        String hql = "SELECT t FROM Tutor t WHERE t.ciclo.idCiclo = :idCiclo";
        tutor = (Tutor) sesion.createQuery(hql).setParameter("idCiclo", idCiclo).uniqueResult();
        endTransaction();
        return tutor;
    }

    @Override
    public List<Object[]> getTutoresAlumnos() {
        startTransaction();
        String hql = "SELECT t, a FROM Tutor t LEFT JOIN t.ciclo c LEFT JOIN Alumno a ON a.ciclo = c";
        List<Object[]> resultado = sesion.createQuery(hql).getResultList();
        endTransaction();
        return resultado;
    }

    @Override
    public List<Tutor> getTutoresSinAlumnos() {
        startTransaction();
        String hql = "SELECT t FROM Tutor t WHERE NOT EXISTS (SELECT a FROM Alumno a WHERE a.ciclo = t.ciclo)";
        List<Tutor> tutores = sesion.createQuery(hql).getResultList();
        endTransaction();
        return tutores;
    }

    @Override
    public List<Object[]> getTutorModulos(Ciclo ciclo) {
        startTransaction();
        String hql = "SELECT t, f.denominacion, m.curso, m.nombre FROM Tutor t JOIN t.ciclo c JOIN c.modulos m LEFT JOIN m.familia f WHERE c = :ciclo";
        List<Object[]> modulos = sesion.createQuery(hql).setParameter("ciclo", ciclo).getResultList();
        endTransaction();
        return modulos;
    }

}
