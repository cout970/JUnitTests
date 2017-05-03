package AccesoDatos;


import Fecha.Fecha;

import java.util.Date;

public class Item {

    private String id;
    private Date fechaDisponible;
    private String nombre;
    private String categoria;
    private int stock;
    private String descripcion;
    private final Fecha cFecha = new Fecha();

    public Item(String id, String fechaDisponible, String nombre, String categoria, int stock, String descripcion) {
        this.fechaDisponible = cFecha.toDate(fechaDisponible);
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaDisponible() {
        return cFecha.toString(fechaDisponible);
    }

    public void setFechaDisponible(String fechaDisponible) {
        this.fechaDisponible = cFecha.toDate(fechaDisponible);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desctripcion) {
        this.descripcion = desctripcion;
    }

}