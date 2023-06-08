package cl.israeljasma.portafolios.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Logro {
    private Integer id;
    private String descripcion;
    private Date fecha;
    private String categoria;
    private String detallesAdicionales;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Logro() {
    }

    public Logro(String descripcion, Date fecha, String categoria, String detallesAdicionales, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
        this.detallesAdicionales = detallesAdicionales;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Logro(int id, String descripcion, Date fecha, String categoria, String detallesAdicionales, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
        this.detallesAdicionales = detallesAdicionales;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDetallesAdicionales() {
        return detallesAdicionales;
    }

    public void setDetallesAdicionales(String detallesAdicionales) {
        this.detallesAdicionales = detallesAdicionales;
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
