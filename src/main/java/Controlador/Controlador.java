package Controlador;

import AccesoDatos.*;
import ModuloEstadistico.Estadistica;
import ModuloEstadistico.Estadisticas;
import ModuloImportacion.Importacion;
import ModuloImportacion.Importador;

import java.util.ArrayList;

public class Controlador implements OperacionesControl {

    private final BaseDatos bd;
    private final Importacion imp;
    private final Estadisticas est;


    public Controlador() {
        bd = new BaseDeDatos();
        imp = new Importador();
        est = new Estadistica(bd);
    }


    @Override
    public void anadirUsuario(Usuario u) {
        bd.anadirUsuario(u);
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        return bd.obtenerUsuario(id);
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return bd.obtenerUsuarios();
    }

    @Override
    public void modificarDniUsuario(String id, String dni) {
        bd.modificarDniUsuario(id, dni);
    }

    @Override
    public void modificarCorreoUsuario(String id, String correo) {
        bd.modificarCorreoUsuario(id, correo);
    }

    @Override
    public void modificarNombreUsuario(String id, String nombre) {
        bd.modificarNombreUsuario(id, nombre);
    }

    @Override
    public void modificarApellidosUsuario(String id, String apellidos) {
        bd.modificarApellidosUsuario(id, apellidos);
    }

    @Override
    public void modificarFechaNacimientoUsuario(String id, String fecha) {
        bd.modificarFechaNacimientoUsuario(id, fecha);
    }

    @Override
    public void modificarFechaAltaUsuario(String id, String fecha) {
        bd.modificarFechaAltaUsuario(id, fecha);
    }

    @Override
    public void darAltaUsuario(String id) {
        bd.darAltaUsuario(id);
    }

    @Override
    public void darBajaUsuario(String id) {
        bd.darBajaUsuario(id);
    }

    @Override
    public void anadirItem(Item i) {
        bd.anadirItem(i);
    }

    @Override
    public Item obtenerItem(String id) {
        return bd.obtenerItem(id);
    }

    @Override
    public ArrayList<Item> obtenerItems() {
        return bd.obtenerItems();
    }

    @Override
    public void modificarFechaItem(String id, String fecha) {
        bd.modificarFechaItem(id, fecha);
    }

    @Override
    public void modificarNombreItem(String id, String nombre) {
        bd.modificarNombreItem(id, nombre);
    }

    @Override
    public void modificarStockItem(String id, int stock) {
        bd.modificarStockItem(id, stock);
    }

    @Override
    public void modificarCategoriaItem(String id, String categoria) {
        bd.modificarCategoriaItem(id, categoria);
    }

    @Override
    public void modificarDescripcionItem(String id, String descripcion) {
        bd.modificarDescripcionItem(id, descripcion);
    }

    @Override
    public void anadirVenta(Venta u) {
        bd.anadirVenta(u);
    }

    @Override
    public Venta obtenerVenta(String id) {
        return bd.obtenerVenta(id);
    }

    @Override
    public ArrayList<Venta> obtenerVentas() {
        return bd.obtenerVentas();
    }

    @Override
    public double ventasSemana() {
        return est.ventasSemana();
    }

    @Override
    public double ventasMes() {
        return est.ventasMes();
    }

    @Override
    public double ventasAno() {
        return est.ventasAno();
    }

    @Override
    public double mediaVentasAno() {
        return est.mediaVentasAno();
    }

    @Override
    public double mediaVentasMes() {
        return est.mediaVentasMes();
    }

    @Override
    public String histogramaVentasMes() {
        return est.histogramaVentasMes();
    }

    @Override
    public String histogramaVentasAno() {
        return est.histogramaVentasAno();
    }

    @Override
    public String porcentajeVentasMes() {
        return est.porcentajeVentasMes();
    }

    @Override
    public String porcentajeVentasAno() {
        return est.porcentajeVentasAno();
    }

    @Override
    public void importarDatos(String nombreFichero) {
        bd.importarDatos(imp.leerFichero(nombreFichero));
    }

}