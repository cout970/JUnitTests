package GUI;

import AccesoDatos.Item;
import AccesoDatos.Usuario;
import AccesoDatos.Venta;
import Controlador.Controlador;
import Controlador.OperacionesControl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class ServicioVentas {

    public static void main(String[] args) {

        OperacionesControl c = new Controlador();

        //PREPARACION DEL ENTORNO
        Usuario u = new Usuario("U-AAAAA-000", "15/04/2017", "Giovanni Jose", "Lopez Reza", "11111111-A");
        Usuario u2 = new Usuario("U-AAAAA-001", "11111112-B", "santijose@gmail.ve", "Andres Santiago", "Gomez Vidal", "13/04/1993", "01/01/2013", true);
        Usuario u3 = new Usuario("U-AAAAA-002", "15/04/2017", "Marcos", "Garcia Rouco", "11111113-C");
        Item i1 = new Item("I-AAAAA-000", "01/01/2001", "Teclado Mecanico", "Oficina", 1000, "Poderoso teclado mecánico que permite terminar los trabajos de Ingeniería del Software lo antes posible");
        Item i2 = new Item("I-AAAAA-001", "02/02/2002", "Mouse Mecanico", "Oficina", 1000, "Poderoso mouse mecánico que permite terminar los trabajos de Ingeniería del Software lo antes posible");
        Item i3 = new Item("I-AAAAA-002", "03/03/2003", "Cafetera Mecanica", "Oficina", 1000, "Poderosa cafetera mecánica que prepara unos poderosos cafes que te ayudaran a mantenerte despierto para terminar los trabajos de Ingeniería del Software lo antes posible");
        Venta v0 = new Venta("V-AAAAA-000", "15/01/2017", "U-AAAAA-000", "I-AAAAA-000", 200, 100);
        Venta v1 = new Venta("V-AAAAA-001", "15/03/2017", "U-AAAAA-000", "I-AAAAA-000", 100, 50);
        Venta v2 = new Venta("V-AAAAA-002", "15/04/2017", "U-AAAAA-001", "I-AAAAA-001", 200, 100);
        Venta v3 = new Venta("V-AAAAA-003", "17/04/2017", "U-AAAAA-002", "I-AAAAA-002", 300, 200);
        Venta v4 = new Venta("V-AAAAA-004", "18/04/2017", "U-AAAAA-002", "I-AAAAA-002", 10, 200.5);


        //FUNCIONES A PROBAR
        c.anadirUsuario(u);
        c.anadirUsuario(u2);
        c.anadirUsuario(u3);

        Usuario u4 = c.obtenerUsuario("U-AAAAA-001");
        System.out.println(u4.getNombre());
        System.out.println("");

        ArrayList<Usuario> usuarios = c.obtenerUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario nº" + (i + 1) + ": " + usuarios.get(i).getNombre());
        }
        System.out.println("");

        Usuario u5 = c.obtenerUsuario("U-AAAAA-001");
        System.out.println("ID: " + u5.getIdUsuario());
        System.out.println("DNI: " + u5.getDni());
        System.out.println("Correo Electronico: " + u5.getCorreoElectronico());
        System.out.println("Nombre: " + u5.getNombre());
        System.out.println("Apellidos: " + u5.getApellidos());
        System.out.println("Fecha Nacimiento: " + u5.getFechaNacimiento());
        System.out.println("Fecha Alta: " + u5.getFechaAlta());
        System.out.println("¿Está Activo?: " + u5.isEstaActivo());
        System.out.println("");

        c.modificarDniUsuario(u5.getIdUsuario(), "22222222-Z");
        c.modificarCorreoUsuario(u5.getIdUsuario(), "santividal@hotmail.com");
        c.modificarNombreUsuario(u5.getIdUsuario(), "Handres Zantiajo");
        c.modificarApellidosUsuario(u5.getIdUsuario(), "Jomes Bidal");
        c.modificarFechaNacimientoUsuario(u5.getIdUsuario(), "25/01/1995");
        c.modificarFechaAltaUsuario(u5.getIdUsuario(), "05/05/2015");
        c.darBajaUsuario(u5.getIdUsuario());

        Usuario u6 = c.obtenerUsuario("U-AAAAA-001");
        System.out.println("ID: " + u6.getIdUsuario());
        System.out.println("DNI: " + u6.getDni());
        System.out.println("Correo Electronico: " + u6.getCorreoElectronico());
        System.out.println("Nombre: " + u6.getNombre());
        System.out.println("Apellidos: " + u6.getApellidos());
        System.out.println("Fecha Nacimiento: " + u6.getFechaNacimiento());
        System.out.println("Fecha Alta: " + u6.getFechaAlta());
        System.out.println("¿Está Activo?: " + u6.isEstaActivo());
        c.darAltaUsuario(u6.getIdUsuario());
        System.out.println("¿Está Activo?: " + u6.isEstaActivo());
        System.out.println("");


        c.anadirItem(i1);
        c.anadirItem(i2);
        c.anadirItem(i3);

        Item i4 = c.obtenerItem("I-AAAAA-002");
        System.out.println(i4.getNombre());
        System.out.println("");

        ArrayList<Item> items = c.obtenerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item nº" + (i + 1) + ": " + items.get(i).getNombre());
        }
        System.out.println("");


        Item i5 = c.obtenerItem("I-AAAAA-000");
        System.out.println("ID: " + i5.getId());
        System.out.println("Nombre: " + i5.getNombre());
        System.out.println("Descripcion: " + i5.getDescripcion());
        System.out.println("Categoria: " + i5.getCategoria());
        System.out.println("Stock: " + i5.getStock());

        c.modificarFechaItem(i5.getId(), "10/02/1980");
        c.modificarNombreItem(i5.getId(), "Teclado de Membrana");
        c.modificarStockItem(i5.getId(), 10000);
        c.modificarCategoriaItem(i5.getId(), "Deportes");
        c.modificarDescripcionItem(i5.getId(), "Utensilio que puede usarse como bate cuando te canses de trabajar en Ingeniería del software");
        System.out.println("");

        Item i6 = c.obtenerItem("I-AAAAA-000");
        System.out.println("ID: " + i6.getId());
        System.out.println("Nombre: " + i6.getNombre());
        System.out.println("Descripcion: " + i6.getDescripcion());
        System.out.println("Categoria: " + i6.getCategoria());
        System.out.println("Stock: " + i6.getStock());
        System.out.println("");


        //VENTAS
        c.anadirVenta(v0);
        c.anadirVenta(v1);
        c.anadirVenta(v2);
        c.anadirVenta(v3);
        c.anadirVenta(v4);

        Venta v5 = c.obtenerVenta("V-AAAAA-002");
        System.out.println("ID: " + v5.getIdFactura());
        System.out.println("Comprador: " + v5.getUsuario());
        System.out.println("Item " + v5.getItem());
        System.out.println("Cantidad: " + v5.getCantidad());
        System.out.println("Fecha Compra: " + v5.getFecha());
        System.out.println("Precio: " + v5.getPrecioUnidad());
        System.out.println("");

        ArrayList<Venta> ventas = c.obtenerVentas();
        for (int i = 0; i < ventas.size(); i++) {
            System.out.println("Venta nº" + (i + 1) + ": " + ventas.get(i).getIdFactura());
        }
        System.out.println("");

        c.importarDatos("build/resources/main/archivoImportacion.txt");

        usuarios = c.obtenerUsuarios();
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario nº" + (i + 1) + ": " + usuarios.get(i).getNombre());
        }
        System.out.println("");

        items = c.obtenerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Item nº" + (i + 1) + ": " + items.get(i).getNombre());
        }
        System.out.println("");

        ventas = c.obtenerVentas();
        for (int i = 0; i < ventas.size(); i++) {
            System.out.println("Venta nº" + (i + 1) + ", con Factura: " + ventas.get(i).getIdFactura() + ", el día: " + ventas.get(i).getFecha());
        }
        System.out.println("");


        System.out.println("Ventas Ano: " + c.ventasAno());
        //prueba de que se actualiza la informacion estadistica
        Venta v6 = new Venta("V-AAAAA-006", "18/04/2017", "U-AAAAA-002", "I-AAAAA-001", 10, 300.5);
        c.anadirVenta(v6);
        System.out.println("Ventas Ano tras añadida venta: " + c.ventasAno());
        System.out.println("");


        System.out.println("Ventas Semana: " + c.ventasSemana());
        System.out.println("Ventas Mes: " + c.ventasMes());
        System.out.println("");


        System.out.println("Media Ventas Mes: " + c.mediaVentasMes());
        System.out.println("Media Ventas Ano: " + c.mediaVentasAno());
        System.out.println("");

        System.out.println("Porcentaje Ventas Mes");
        System.out.println(c.porcentajeVentasMes());
        System.out.println("");
        System.out.println("Porcentaje Ventas Año");
        System.out.println(c.porcentajeVentasAno());
        System.out.println("");


        System.out.println("Histograma Ventas Mes");
        System.out.println(c.histogramaVentasMes());
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Histograma Ventas Año");
        System.out.println(c.histogramaVentasAno());
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

}
