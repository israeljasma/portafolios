package cl.israeljasma.portafolios.models.entity;

import cl.israeljasma.portafolios.models.Referencia;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_experiences")
public class ExperienciaLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String cargo;
    private LocalDate fechaInicio;
    private LocalDate fechaTermino;
    private String descripcion;
    private String referenciaContacto;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant fechaCreacion;
    @Temporal(TemporalType.TIMESTAMP)
    private Instant fechaModificacion;
    private int idPerfil;
    //private List<Referencia> referencias;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String empresa, String cargo, LocalDate fechaInicio, LocalDate fechaTermino, String descripcion, String referenciaContacto, Instant fechaCreacion, Instant fechaModificacion, int idPerfil) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.referenciaContacto = referenciaContacto;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
        //this.referencias = new ArrayList<>();
    }

    public ExperienciaLaboral(Long id, String empresa, String cargo, LocalDate fechaInicio, LocalDate fechaTermino, String descripcion, String referenciaContacto, Instant fechaCreacion, Instant fechaModificacion, int idPerfil) {
        this.id = id;
        this.empresa = empresa;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.referenciaContacto = referenciaContacto;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
        //this.referencias = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        cargo = cargo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(LocalDate fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferenciaContacto() {
        return referenciaContacto;
    }

    public void setReferenciaContacto(String referenciaContacto) {
        this.referenciaContacto = referenciaContacto;
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

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
}
