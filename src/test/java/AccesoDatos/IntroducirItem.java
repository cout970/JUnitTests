package AccesoDatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 * <p>
 */
public class IntroducirItem {

    private BaseDatos baseDatos;

    @Before
    public void setup() {
        baseDatos = new BaseDeDatos();
    }

    // CP 022
    @Test
    public void anadirItemValido() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        baseDatos.anadirItem(item);

        assertEquals(1, baseDatos.obtenerItems().size());
        assertEquals(item, baseDatos.obtenerItems().get(0));
    }

    // CP 023
    @Test
    public void anadirItemConIdInvalido() throws Exception {
        Item item = new Item(
                "I-ABCDE000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        try {
            baseDatos.anadirItem(item);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerItems().size());
    }

    // CP 024
    @Test
    public void anadirItemConCategoriaInvalida() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida, Esto no es una categoría válida.",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        try {
            baseDatos.anadirItem(item);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerItems().size());
    }

    // CP 025
    @Test
    public void anadirItemConIdEnMayusculasYMinusculas() throws Exception {
        Item item = new Item(
                "I-AbCDe-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        baseDatos.anadirItem(item);

        assertEquals(1, baseDatos.obtenerItems().size());
        assertEquals(item, baseDatos.obtenerItems().get(0));
    }

    // CP 026
    @Test
    public void anadirItemConNombreInvalido() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico Destornillador sónico.",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        try {
            baseDatos.anadirItem(item);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerItems().size());
    }

    // CP 027
    @Test
    public void anadirItemConFechaEnElMaravillosoFuturoDe2038() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2040",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        baseDatos.anadirItem(item);

        assertEquals(1, baseDatos.obtenerItems().size());
        assertEquals(item, baseDatos.obtenerItems().get(0));
    }

    // CP 028
    @Test
    public void anadirItemConFormatoDeFechaInvalido() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/17",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        try {
            baseDatos.anadirItem(item);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerItems().size());
    }

    // CP 029
    @Test
    public void anadirItemConStockNegativo() throws Exception {
        Item item = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                -360,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        try {
            baseDatos.anadirItem(item);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(0, baseDatos.obtenerItems().size());
    }

    // CP 030
    // Invalidad, no tiene sentido en java
//    @Test
//    public void anadirItemConStockConPuntoFlotante() throws Exception {
//        Item item = Mockito.mock(Item.class);
//
//        Mockito.when(item.getId()).thenReturn("I-ABCDE-000");
//        Mockito.when(item.getFechaDisponible()).thenReturn("20/03/2017");
//        Mockito.when(item.getNombre()).thenReturn("Destornillador sónico");
//        Mockito.when(item.getCategoria()).thenReturn("Herramientas");
//        Mockito.when(item.getStock()).thenReturn(Float.floatToIntBits(4.20f));
//        Mockito.when(item.getDescripcion()).thenReturn("Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena.");
//
//        try {
//            baseDatos.anadirItem(item);
//            Assert.fail("No se ha lanzado una excepcion");
//        } catch (Exception e) {
//            assertEquals(IllegalArgumentException.class, e.getClass());
//        }
//        assertEquals(0, baseDatos.obtenerItems().size());
//    }

    // CP 031
    @Test
    public void anadirItemYaExistente() throws Exception {
        Item item0 = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );
        Item item1 = new Item(
                "I-ABCDE-000",
                "20/03/2017",
                "Destornillador sónico",
                "Herramientas",
                420,
                "Herramienta multifuncional utilizada por el Doctor. Su función más común es la de forzar cerraduras para abrir puertas, pero se le pueden dar otros usos como el de realizar chequeos médicos, controlar remotamente otros aparatos, operar la TARDIS y rastrear vida alienígena. Puede, con la excepción de un cierre hermético o de una puerta de madera, abrir cualquier tipo de cierres y operar varias computadoras, de origen humano o alienígena."
        );

        baseDatos.anadirItem(item0);

        try {
            baseDatos.anadirItem(item1);
            Assert.fail("No se ha lanzado una excepcion");
        } catch (Exception e) {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
        assertEquals(1, baseDatos.obtenerItems().size());
        assertEquals(item0, baseDatos.obtenerItems().get(0));
    }
}
