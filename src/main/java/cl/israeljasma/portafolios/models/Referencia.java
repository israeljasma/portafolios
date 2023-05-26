package cl.israeljasma.portafolios.models;

import java.sql.Timestamp;

public class Referencia {
    private int id;
    private String nombre;
    private String cargo;
    private String empresa;
    private String email;
    private String telefono;
    private String relacion;
    private Timestamp fechaCreacion;
    private Timestamp fechaModificacion;
    private int idPerfil;

    public Referencia() {
    }

    public Referencia(String nombre, String cargo, String empresa, String email, String telefono, String relacion, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.email = email;
        this.telefono = telefono;
        this.relacion = relacion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.idPerfil = idPerfil;
    }

    public Referencia(int id, String nombre, String cargo, String empresa, String email, String telefono, String relacion, Timestamp fechaCreacion, Timestamp fechaModificacion, int idPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.email = email;
        this.telefono = telefono;
        this.relacion = relacion;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
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
