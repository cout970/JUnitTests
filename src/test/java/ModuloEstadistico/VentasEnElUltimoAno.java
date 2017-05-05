package ModuloEstadistico;

import AccesoDatos.BaseDatos;
import AccesoDatos.BaseDeDatos;
import AccesoDatos.Venta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class})
public class VentasEnElUltimoAno {

    @Before
    public void setup() {

        Calendar fechaPrueba = Calendar.getInstance();
        fechaPrueba.set(2017, Calendar.MAY, 31);

        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(fechaPrueba);

        assertEquals(fechaPrueba, Calendar.getInstance());
    }

    // CP 050
    @Test
    public void ventasAnoConBBDDVacia() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);

        ArrayList<Venta> resultado = estadisticas.obtenerVentasAno();

        assertEquals(Collections.emptyList(), resultado);
    }

    // CP 051
    @Test
    public void ventasAnoConBBDDConUnaVentaDeHaceMasDeUnAno() throws Exception {

        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);
        ArrayList<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(
                "V-ABCDEF-000",
                "01/05/2015",
                "U-ABCDEF-000",
                "I-ABCDEF-000",
                0,
                1.0
        ));

        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventas);

        ArrayList<Venta> resultado = estadisticas.obtenerVentasAno();

        assertEquals(Collections.emptyList(), resultado);
    }


    // CP 052
    @Test
    public void ventasAnoConBBDDConUnaVenta() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);
        ArrayList<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(
                "V-ABCDEF-000",
                "01/01/2017",
                "U-ABCDEF-000",
                "I-ABCDEF-000",
                0,
                1.0
        ));
        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventas);

        ArrayList<Venta> resultado = estadisticas.obtenerVentasAno();

        assertEquals(1, resultado.size());
        assertEquals(ventas, resultado);
    }
}
