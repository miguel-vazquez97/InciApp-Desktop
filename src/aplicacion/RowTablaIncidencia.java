package aplicacion;

import java.util.Date;

/**
 *
 * @author mivap
 */
public class RowTablaIncidencia {
    private int id;
    private Date fecha;
    private String tipo;
    private String descripcion;
    private String direccion;

    public RowTablaIncidencia(int id, Date fecha, String tipo, String descripcion, String direccion){        
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
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
}
