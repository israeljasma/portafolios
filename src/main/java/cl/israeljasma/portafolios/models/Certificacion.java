package cl.israeljasma.portafolios.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Certificacion {
    private Integer id;
    private String institucionEmisora;
    private Date fechaObetencion;
    private String descripcion;
    private String url;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Certificacion() {
    }

    public Certificacion(String institucionEmisora, Date fechaObetencion, String descripcion, String url, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.institucionEmisora = institucionEmisora;
        this.fechaObetencion = fechaObetencion;
        this.descripcion = descripcion;
        this.url = url;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Certificacion(int id, String institucionEmisora, Date fechaObetencion, String descripcion, String url, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.institucionEmisora = institucionEmisora;
        this.fechaObetencion = fechaObetencion;
        this.descripcion = descripcion;
        this.url = url;
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

    public String getInstitucionEmisora() {
        return institucionEmisora;
    }

    public void setInstitucionEmisora(String institucionEmisora) {
        this.institucionEmisora = institucionEmisora;
    }

    public Date getFechaObetencion() {
        return fechaObetencion;
    }

    public void setFechaObetencion(Date fechaObetencion) {
        this.fechaObetencion = fechaObetencion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
