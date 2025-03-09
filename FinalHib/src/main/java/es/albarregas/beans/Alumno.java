
package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "FK_alumnos_usuarios"))
public class Alumno extends Usuario implements Serializable{
    public enum Genero{
        MUJER, HOMBRE, OTRO
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "Genero", nullable = false, length = 6)
    private Genero genero = Genero.MUJER;
    @Temporal(TemporalType.DATE)
    @Column(name = "FechaNacimiento")
    private Date fechaNacimiento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCiclo", foreignKey = @ForeignKey(name = "FK_alumno_ciclo"))
    private Ciclo ciclo;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "IdAlumno", foreignKey = @ForeignKey(name = "FK_alumno_notas"))
    private List<Nota> notas;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }
}
