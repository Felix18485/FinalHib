package es.albarregas.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "modulos")
public class Modulo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idModulo;
    @Column(name = "Abreviatura", length = 5, nullable = false)
    private String abreviatura;
    @Column(name = "Curso", length = 1, nullable = false)
    private String curso;
    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "Horas", nullable = false)
    private short horas;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Familia")
    private Familia familia;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "modulos")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Ciclo> ciclo;

    public short getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(short idModulo) {
        this.idModulo = idModulo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getHoras() {
        return horas;
    }

    public void setHoras(short horas) {
        this.horas = horas;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public Set<Ciclo> getCiclo() {
        return ciclo;
    }

    public void setCiclo(Set<Ciclo> ciclo) {
        this.ciclo = ciclo;
    }
    
}
