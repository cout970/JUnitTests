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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (stock != item.stock) return false;
        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (fechaDisponible != null ? !fechaDisponible.equals(item.fechaDisponible) : item.fechaDisponible != null)
            return false;
        if (nombre != null ? !nombre.equals(item.nombre) : item.nombre != null) return false;
        if (categoria != null ? !categoria.equals(item.categoria) : item.categoria != null) return false;
        if (descripcion != null ? !descripcion.equals(item.descripcion) : item.descripcion != null) return false;
        return cFecha != null ? cFecha.equals(item.cFecha) : item.cFecha == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fechaDisponible != null ? fechaDisponible.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (categoria != null ? categoria.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (cFecha != null ? cFecha.hashCode() : 0);
        return result;
    }
}