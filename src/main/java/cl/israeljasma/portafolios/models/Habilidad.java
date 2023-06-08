package cl.israeljasma.portafolios.models;

import java.sql.Timestamp;

public class Habilidad {
    private Integer id;
    private String nombre;
    private int nivel;
    private String descripcion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Habilidad() {
    }

    public Habilidad(String nombre, int nivel, String descripcion, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Habilidad(int id, String nombre, int nivel, String descripcion, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
        this.descripcion = descripcion;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
