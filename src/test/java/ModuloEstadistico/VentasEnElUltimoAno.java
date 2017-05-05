package ModuloEstadistico;

import AccesoDatos.BaseDatos;
import AccesoDatos.BaseDeDatos;
import AccesoDatos.Venta;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Couto
 */
public class VentasEnElUltimoAno {

    @Test
    public void ventasAnoConBBDDVacia() throws Exception {
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);

        String resultado = estadisticas.histogramaVentasAno();

        assertEquals("" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "-----------------------------------------------------", resultado);
    }

    @Test
    public void ventasAnoConBBDDConUnaVentaDeHaceMasDeUnAno() throws Exception {

        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);
        ArrayList<Venta> ventas = new ArrayList<>();

        ventas.add(new Venta(
                "V-ABCDEF-000",
                "01/01/1987",
                "U-ABCDEF-000",
                "I-ABCDEF-000",
                0,
                1.0
        ));

        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventas);

        String resultado = estadisticas.histogramaVentasAno();

        assertEquals("" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "|                                                    \n" +
                "-----------------------------------------------------", resultado);
    }


    @Test
    public void ventasAnoConBBDDConUnaVenta() throws Exception {}
}
