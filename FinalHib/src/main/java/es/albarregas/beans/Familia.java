package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "familias")
public class Familia implements Serializable{
    @Id
    @Column(name = "IdFamilia", length = 3)
    private String idFamilia;
    @Column(name = "Denominacion", length = 30, nullable = false)
    private String denominacion;

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    
}
