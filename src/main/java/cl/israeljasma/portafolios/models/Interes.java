package cl.israeljasma.portafolios.models;

import java.sql.Timestamp;

public class Interes {
    private int id;
    private String descripcion;
    private String categoria;
    private String nivel;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Interes() {
    }

    public Interes(String descripcion, String categoria, String nivel, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nivel = nivel;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Interes(int id, String descripcion, String categoria, String nivel, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.nivel = nivel;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
