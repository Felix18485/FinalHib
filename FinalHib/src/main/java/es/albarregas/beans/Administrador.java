package es.albarregas.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "IdUsuario", foreignKey = @ForeignKey(name = "FK_administradores_usuarios"))
public class Administrador extends Usuario implements Serializable {

    @Column(name = "ModoDios", length = 1)
    @Type(type = "true_false")
    private boolean modoDios;

    public boolean isModoDios() {
        return modoDios;
    }

    public void setModoDios(boolean modoDios) {
        this.modoDios = modoDios;
    }

}
