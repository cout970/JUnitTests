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

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 * <p>
 * TODO Couto
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Calendar.class})
public class PorcentajeDeVentasDiariasSobreElTotalDelMes {

    @Before
    public void setup() {
        Calendar fechaPrueba = Calendar.getInstance();
        fechaPrueba.set(2017, Calendar.MAY, 31);

        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(fechaPrueba);

        assertEquals(fechaPrueba, Calendar.getInstance());
    }

    // CP 047
    @Test
    public void porcentajeVentasMesConLaBBDDVacia() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);

        String resultado = estadisticas.porcentajeVentasMes();

        assertEquals("", resultado);
    }

    // CP 048
    @Test
    public void porcentajeVentasMesConLaBBDDConUnaVentaConPrecioCero() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);
        ArrayList<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(
                "V-ABCDEF-000",
                "01/05/2017",
                "U-ABCDEF-000",
                "I-ABCDEF-000",
                1,
                0.0
        ));

        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventas);

        String resultado = estadisticas.porcentajeVentasMes();

        assertEquals("", resultado);
    }

    // CP 049
    @Test
    public void porcentajeVentasMesConLaBBDDConUnaVentaValida() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);
        ArrayList<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(
                "V-ABCDEF-000",
                "01/05/2017",
                "U-ABCDEF-000",
                "I-ABCDEF-000",
                1,
                10.0
        ));

        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventas);

        String resultado = estadisticas.porcentajeVentasMes();

        assertEquals("Día 1: 100.0%", resultado);
    }
}
