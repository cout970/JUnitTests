package AccesoDatos;

import java.util.ArrayList;

public class BaseDeDatos implements BaseDatos {

    private final ArrayList<Usuario> usuarios;
    private final ArrayList<Item> items;
    private final ArrayList<Venta> ventas;

    public BaseDeDatos() {
        usuarios = new ArrayList<Usuario>();
        items = new ArrayList<Item>();
        ventas = new ArrayList<Venta>();
    }

    private boolean contieneUsuario(String id) {
        boolean respuesta = false;

        Usuario usuario;
        for (int i = 0; i < usuarios.size(); i++) {
            usuario = usuarios.get(i);
            if (id.equals(usuario.getIdUsuario())) {
                respuesta = true;
                break;
            }
        }

        return respuesta;
    }

    private boolean contieneVenta(String id) {
        boolean respuesta = false;

        Venta venta;
        for (int i = 0; i < ventas.size(); i++) {
            venta = ventas.get(i);
            if (id.equals(venta.getIdFactura())) {
                respuesta = true;
                break;
            }
        }

        return respuesta;
    }

    private boolean contieneItem(String id) {
        boolean respuesta = false;

        Item item;
        for (int j = 0; j < items.size(); j++) {
            item = items.get(j);
            if (id.equals(item.getId())) {
                respuesta = true;
                break;
            }
        }

        return respuesta;
    }

    @Override
    public void anadirUsuario(Usuario u) {


        if (!contieneUsuario(u.getIdUsuario())) {
            usuarios.add(u);
        }

    }

    @Override
    public void anadirVenta(Venta v) {

        if (!contieneVenta(v.getIdFactura()) && contieneUsuario(v.getUsuario()) && contieneItem(v.getItem()) && (obtenerItem(v.getItem()).getStock() >= v.getCantidad())) {
            ventas.add(v);
            obtenerItem(v.getItem()).setStock(obtenerItem(v.getItem()).getStock() - v.getCantidad());
        }

    }

    @Override
    public void anadirItem(Item i) {

        if (!contieneItem(i.getId())) {
            items.add(i);
        }

    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    @Override
    public ArrayList<Venta> obtenerVentas() {
        return ventas;
    }

    @Override
    public ArrayList<Item> obtenerItems() {
        return items;
    }

    @Override
    public Usuario obtenerUsuario(String id) {

        Usuario u = null;

        for (int i = 0; i < usuarios.size(); i++) {
            u = usuarios.get(i);
            if (u.getIdUsuario().equals(id)) {
                break;
            }
        }

        return u;
    }

    @Override
    public Venta obtenerVenta(String id) {

        Venta v = null;

        for (int i = 0; i < ventas.size(); i++) {
            v = ventas.get(i);
            if (v.getIdFactura().equals(id)) {
                break;
            }
        }

        return v;

    }

    @Override
    public Item obtenerItem(String id) {

        Item it = null;

        for (int i = 0; i < items.size(); i++) {
            it = items.get(i);
            if (it.getId().equals(id)) {
                break;
            }
        }

        return it;

    }

    @Override
    public void importarDatos(BaseDeDatos bd) {

        Usuario u;
        Item it;
        Venta v;

        for (int i = 0; i < bd.obtenerUsuarios().size(); i++) {
            u = bd.obtenerUsuarios().get(i);
            if (!contieneUsuario(u.getIdUsuario())) {
                anadirUsuario(u);
            }
        }

        for (int i = 0; i < bd.obtenerItems().size(); i++) {
            it = bd.obtenerItems().get(i);
            if (!contieneItem(it.getId())) {
                anadirItem(it);
            }
        }

        for (int i = 0; i < bd.obtenerVentas().size(); i++) {
            v = bd.obtenerVentas().get(i);
            if (!contieneVenta(v.getIdFactura()) && contieneUsuario(v.getUsuario()) && contieneItem(v.getItem())) {
                anadirVenta(v);
            }
        }

    }

    @Override
    public void modificarDniUsuario(String id, String dni) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setDni(dni);
        }

    }

    @Override
    public void modificarCorreoUsuario(String id, String correo) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setCorreoElectronico(correo);
        }

    }

    @Override
    public void modificarNombreUsuario(String id, String nombre) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setNombre(nombre);
        }

    }

    @Override
    public void modificarApellidosUsuario(String id, String apellidos) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setApellidos(apellidos);
        }

    }

    @Override
    public void modificarFechaNacimientoUsuario(String id, String fecha) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setFechaNacimiento(fecha);
        }

    }

    @Override
    public void modificarFechaAltaUsuario(String id, String fecha) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setFechaAlta(fecha);
        }

    }

    @Override
    public void darAltaUsuario(String id) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setEstaActivo(true);
        }
    }

    @Override
    public void darBajaUsuario(String id) {

        Usuario u = obtenerUsuario(id);
        if (u != null) {
            u.setEstaActivo(false);
        }

    }

    @Override
    public void modificarFechaItem(String id, String fecha) {

        Item i = obtenerItem(id);
        if (i != null) {
            i.setFechaDisponible(fecha);
        }
    }

    @Override
    public void modificarNombreItem(String id, String nombre) {
        Item i = obtenerItem(id);
        if (i != null) {
            i.setNombre(nombre);
        }
    }

    @Override
    public void modificarStockItem(String id, int stock) {
        Item i = obtenerItem(id);
        if (i != null) {
            i.setStock(stock);
        }
    }

    @Override
    public void modificarCategoriaItem(String id, String categoria) {
        Item i = obtenerItem(id);
        if (i != null) {
            i.setCategoria(categoria);
        }
    }

    @Override
    public void modificarDescripcionItem(String id, String descripcion) {
        Item i = obtenerItem(id);
        if (i != null) {
            i.setDescripcion(descripcion);
        }
    }

}