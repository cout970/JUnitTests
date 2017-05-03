package AccesoDatos;

import Fecha.Fecha;

import java.util.Date;

public class Venta {

    private String idFactura;
    private Date fecha;
    private String usuario;
    private String item;
    private int cantidad;
    private double precioUnidad;
    private final Fecha cFecha = new Fecha();

    public Venta(String idFactura, String fecha, String usuario, String item, int cantidad, double precioUnidad) {
        this.fecha = cFecha.toDate(fecha);
        this.idFactura = idFactura;
        this.usuario = usuario;
        this.item = item;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getFecha() {
        return cFecha.toString(fecha);
    }

    public void setFecha(String fecha) {
        this.fecha = cFecha.toDate(fecha);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

}