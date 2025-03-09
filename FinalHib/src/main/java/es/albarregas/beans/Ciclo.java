package es.albarregas.beans;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "ciclos")
public class Ciclo implements Serializable {

    @Id
    @Column(name = "IdCiclo", length = 7)
    private String idCiclo;
    @Column(name = "Abreviatura", length = 4, nullable = false)
    private String abreviatura;
    @Column(name = "Nombre", length = 100, nullable = false)
    private String nombre;
    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ciclosmodulos",
            joinColumns = @JoinColumn(name = "IdCiclo"),
            foreignKey = @ForeignKey(name = "FK_ciclosmodulos_ciclo"),
            inverseJoinColumns = @JoinColumn(name = "IdModulo"),
            inverseForeignKey = @ForeignKey(name = "FK_ciclosmodulos_modulo"))
    private Set<Modulo> modulos;

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
    }
    
}
