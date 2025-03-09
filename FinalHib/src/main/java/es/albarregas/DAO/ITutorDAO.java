package es.albarregas.DAO;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Tutor;
import java.util.List;

/**
 *
 * @author sarap
 */
public interface ITutorDAO {
    public Tutor comprobarTutorCiclo(String idCiclo);
    public List<Object[]> getTutoresAlumnos();
    public List<Tutor> getTutoresSinAlumnos();
    public List<Object[]> getTutorModulos(Ciclo ciclo);
}
