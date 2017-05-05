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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venta venta = (Venta) o;

        if (cantidad != venta.cantidad) return false;
        if (Double.compare(venta.precioUnidad, precioUnidad) != 0) return false;
        if (idFactura != null ? !idFactura.equals(venta.idFactura) : venta.idFactura != null) return false;
        if (fecha != null ? !fecha.equals(venta.fecha) : venta.fecha != null) return false;
        if (usuario != null ? !usuario.equals(venta.usuario) : venta.usuario != null) return false;
        if (item != null ? !item.equals(venta.item) : venta.item != null) return false;
        return cFecha != null ? cFecha.equals(venta.cFecha) : venta.cFecha == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idFactura != null ? idFactura.hashCode() : 0;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + cantidad;
        temp = Double.doubleToLongBits(precioUnidad);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (cFecha != null ? cFecha.hashCode() : 0);
        return result;
    }
}