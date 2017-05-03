package Controlador;

import AccesoDatos.Item;
import AccesoDatos.Usuario;
import AccesoDatos.Venta;

import java.util.ArrayList;

public interface OperacionesControl {

    //USUARIOS
    public void anadirUsuario(Usuario u); //

    public Usuario obtenerUsuario(String id);

    public ArrayList<Usuario> obtenerUsuarios();

    public void modificarDniUsuario(String id, String dni);

    public void modificarCorreoUsuario(String id, String correo);

    public void modificarNombreUsuario(String id, String nombre);

    public void modificarApellidosUsuario(String id, String apellidos);

    public void modificarFechaNacimientoUsuario(String id, String fecha);

    public void modificarFechaAltaUsuario(String id, String fecha);

    public void darAltaUsuario(String id);

    public void darBajaUsuario(String id);

    //ITEMS
    public void anadirItem(Item i);

    public Item obtenerItem(String id);

    public ArrayList<Item> obtenerItems();

    public void modificarFechaItem(String id, String fecha);

    public void modificarNombreItem(String id, String nombre);

    public void modificarStockItem(String id, int stock);

    public void modificarCategoriaItem(String id, String categoria);

    public void modificarDescripcionItem(String id, String descripcion);

    //VENTAS
    public void anadirVenta(Venta u);

    public Venta obtenerVenta(String id);

    public ArrayList<Venta> obtenerVentas();

    //ESTADISTICAS
    public double ventasSemana();

    public double ventasMes();

    public double ventasAno();

    public double mediaVentasAno();

    public double mediaVentasMes();

    public String histogramaVentasMes();

    public String histogramaVentasAno();

    public String porcentajeVentasMes();

    public String porcentajeVentasAno();

    //IMPORTAR DATOS
    public void importarDatos(String nombreFichero);

}
