package aplicacion;

import java.util.Date;

/**
 *
 * @author mivap
 */
public class Incidencia {
    
    private int id;
    private String nombreCiudadano;
    private String correoCiudadano;
    private String tipo;
    private String fecha;
    private String descripcion;
    private String direccion;
    private String departamento;
    private String imagenBase64;

    public Incidencia(int id, String nombreCiudadano, String correoCiudadano, String tipo, String fecha, String descripcion, String direccion, String departamento, String imagenBase64) {
        this.id = id;
        this.nombreCiudadano = nombreCiudadano;
        this.correoCiudadano = correoCiudadano;
        this.tipo = tipo;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.departamento = departamento;
        this.imagenBase64 = imagenBase64;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudadano() {
        return nombreCiudadano;
    }

    public void setNombreCiudadano(String nombreCiudadano) {
        this.nombreCiudadano = nombreCiudadano;
    }

    public String getCorreoCiudadano() {
        return correoCiudadano;
    }

    public void setCorreoCiudadano(String correoCiudadano) {
        this.correoCiudadano = correoCiudadano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getImagenBase64() {
        return imagenBase64;
    }

    public void setImagenBase64(String imagenBase64) {
        this.imagenBase64 = imagenBase64;
    }
    
    
    
}
