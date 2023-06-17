package cl.israeljasma.portafolios.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty
    private String username;

    @Column(unique = true)
    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    private Boolean active;

    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant fechaCreacion;

    @Column(name = "fechaModificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Instant fechaModificacion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    //private Perfil perfil;

    @PrePersist
    public void prePersist(){
        active = true;
        fechaCreacion = Instant.now();
        fechaModificacion = Instant.now();
    }

    public Usuario() {
    }

    public Usuario(String username, String email, String password, Boolean active, Instant fechaCreacion, Instant fechaModificacion, List<Authority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Instant getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Instant fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Instant getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Instant fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    // public Perfil getPerfil() {
     //   return perfil;
   // }

    //public void setPerfil(Perfil perfil) {
      //  this.perfil = perfil;
   // }
}
