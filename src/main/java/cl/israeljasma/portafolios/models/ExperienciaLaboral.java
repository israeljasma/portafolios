package cl.israeljasma.portafolios.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ExperienciaLaboral {
    private Integer id;
    private String empresa;
    private String Cargo;
    private Date fechaInicio;
    private Date fechaTermino;
    private String descripcion;
    private String referenciaContacto;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;
    private List<Referencia> referencias;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String empresa, String cargo, Date fechaInicio, Date fechaTermino, String descripcion, String referenciaContacto, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.empresa = empresa;
        Cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.referenciaContacto = referenciaContacto;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
        this.referencias = new ArrayList<>();
    }

    public ExperienciaLaboral(int id, String empresa, String cargo, Date fechaInicio, Date fechaTermino, String descripcion, String referenciaContacto, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.empresa = empresa;
        Cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.referenciaContacto = referenciaContacto;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
        this.referencias = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
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

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
}
