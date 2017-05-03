package AccesoDatos;

import java.util.ArrayList;

public interface BaseDatos {

    public ArrayList<Usuario> obtenerUsuarios();

    public ArrayList<Venta> obtenerVentas();

    public ArrayList<Item> obtenerItems();

    public void anadirUsuario(Usuario u);

    public void anadirVenta(Venta u);

    public void anadirItem(Item i);

    public Usuario obtenerUsuario(String id);

    public Venta obtenerVenta(String id);

    public Item obtenerItem(String id);

    public void importarDatos(BaseDeDatos bd);

    public void modificarDniUsuario(String id, String dni);

    public void modificarCorreoUsuario(String id, String correo);

    public void modificarNombreUsuario(String id, String nombre);

    public void modificarApellidosUsuario(String id, String apellidos);

    public void modificarFechaNacimientoUsuario(String id, String fecha);

    public void modificarFechaAltaUsuario(String id, String fecha);

    public void darAltaUsuario(String id);

    public void darBajaUsuario(String id);

    public void modificarFechaItem(String id, String fecha);

    public void modificarNombreItem(String id, String nombre);

    public void modificarStockItem(String id, int stock);

    public void modificarCategoriaItem(String id, String categoria);

    public void modificarDescripcionItem(String id, String descripcion);

}