package cl.israeljasma.portafolios.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Educacion {
    private Integer id;
    private String institucion;
    private String titulo;
    private Date fechaInicio;
    private Date fechaTermino;
    private String descripcion;
    private String pais;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Educacion() {
    }

    public Educacion(String institucion, String titulo, Date fechaInicio, Date fechaTermino, String descripcion, String pais, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.pais = pais;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Educacion(int id, String institucion, String titulo, Date fechaInicio, Date fechaTermino, String descripcion, String pais, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.descripcion = descripcion;
        this.pais = pais;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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
