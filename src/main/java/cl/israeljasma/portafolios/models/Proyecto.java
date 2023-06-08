package cl.israeljasma.portafolios.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Proyecto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String rol;
    private Date fechaInicio;
    private Date fechaTermino;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String rol, Date fechaInicio, Date fechaTermino, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Proyecto(int id, String nombre, String descripcion, String rol, Date fechaInicio, Date fechaTermino, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rol = rol;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
