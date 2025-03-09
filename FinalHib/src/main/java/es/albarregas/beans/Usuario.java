package es.albarregas.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author sarap
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = "Email", name = "UK_usuarios_email"), @UniqueConstraint(columnNames = "DNI", name = "UK_usuarios_dni")})
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable{
    public enum Rol{
        ADMIN, TUTOR, ALUMNO
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(name = "Email", length = 60, nullable = false)
    private String email;
    @Column(name = "Password", length = 128, nullable = false)
    private String password;
    @Column(name = "Nombre",length = 30)
    private String nombre;
    @Column(name = "Apellidos", length = 60)
    private String apellidos;
    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", nullable = false, length = 6)
    private Rol rol;
    @Column(name = "DNI", length = 9)
    private String dni;
    @Temporal(TemporalType.DATE)
    @Column(name = "UltimoAcceso")
    private Date ultimoAcceso;
    @Column(name = "Avatar", nullable = false, length = 30)
    private String avatar = "avatar.png";

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}
