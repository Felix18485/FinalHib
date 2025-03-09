package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "notas")
public class Nota implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNota;
    @Column(name = "Nota", nullable = false)
    private byte nota;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdAlumno", foreignKey = @ForeignKey(name = "FK_notas_alumnos"))
    private Alumno alumno;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdModulo", foreignKey = @ForeignKey(name = "FK_notas_modulos"))
    private Modulo modulo;

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public byte getNota() {
        return nota;
    }

    public void setNota(byte nota) {
        this.nota = nota;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
    
}
