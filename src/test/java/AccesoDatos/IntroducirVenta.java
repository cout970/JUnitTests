package AccesoDatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 * <p>
 */

public class IntroducirVenta {

    private BaseDatos baseDatos;

    @Before
    public void setup() {
        baseDatos = new BaseDeDatos();

        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );
        Usuario user = new Usuario(
                "U-ABCDE-000",
                "10000000X",
                "nombre.apellido@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );

        baseDatos.anadirItem(item);
        baseDatos.anadirUsuario(user);
    }


    // CP 031
    @Test
    public void anadirVentaValida() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        baseDatos.anadirVenta(venta);

        assertEquals(1, baseDatos.obtenerVentas().size());
        assertEquals(venta, baseDatos.obtenerVentas().get(0));
    }

    // CP 032
    @Test
    public void anadirVentaConIdInvalida() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-00A",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 033
    @Test
    public void anadirVentaConIdNulo() throws Exception {
        Venta venta = new Venta(
                null,
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 034
    @Test
    public void anadirVentaConFormatoInvalidoDeFecha() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13-04-2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 035
    @Test
    public void anadirVentaConFechaNula() throws Exception {

        Venta venta = new Venta(
                "V-ABCDE-000",
                null,
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 036
    @Test
    public void anadirVentaConCantidadNegativa() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                -1,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 037
    @Test
    public void anadirVentaConPrecioUnitarioNegativo() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                -1
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 038
    @Test
    public void anadirVentaConPrecioUnitarioCero() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                0
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 039
    @Test
    public void anadirVentaConIdDeUsuarioConFormatoInvalido() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-00",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 040
    @Test
    public void anadirVentaConIdDeItemConFormatoInvalido() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-00",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 041
    @Test
    public void anadirVentaConFechaDelFuturo() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/2038",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        try {
            baseDatos.anadirVenta(venta);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerVentas().size());
    }

    // CP 042
    @Test
    public void anadirVentaConFechaAnteriorA1970() throws Exception {
        Venta venta = new Venta(
                "V-ABCDE-000",
                "13/04/1969",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        baseDatos.anadirVenta(venta);

        assertEquals(1, baseDatos.obtenerVentas().size());
        assertEquals(venta, baseDatos.obtenerVentas().get(0));
    }

    // CP  043
    @Test
    public void anadirVentaDosVeces() throws Exception {
        Venta venta0 = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );
        Venta venta1 = new Venta(
                "V-ABCDE-000",
                "13/04/2016",
                "U-ABCDE-000",
                "I-ABCDE-000",
                10,
                1.99
        );

        baseDatos.anadirVenta(venta0);
        try {
            baseDatos.anadirVenta(venta1);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(1, baseDatos.obtenerVentas().size());
        assertEquals(venta0, baseDatos.obtenerVentas().get(0));
    }
}
