package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "tutores")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "FK_tutores_usuarios"))
public class Tutor extends Usuario implements Serializable{
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCiclo", foreignKey = @ForeignKey(name = "FK_tutores_ciclos"))
    private Ciclo ciclo;

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
}
