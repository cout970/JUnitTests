package ModuloEstadistico;

import AccesoDatos.BaseDatos;
import AccesoDatos.BaseDeDatos;
import AccesoDatos.Venta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Pedro
 */
public class HistogramaDeVentasDiariasEnElUltimoMes {

    @Before
    public void setup(){
        /*TODO Cambiar fecha*/
    }


    @Test
    public void histogramaVentasMesConBBDDVacia() throws Exception {


        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadisticas estadisticas = new Estadistica(baseDeDatos);


        String resultado = estadisticas.histogramaVentasMes();

        Assert.assertEquals(""+
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "--------------------------------" , resultado);

    }

    @Test
    public void histogramaVentasMesConLaBBDDConUnaSolaVentaDeHaceMasDeUnMes() throws Exception {

        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Venta venta = Mockito.mock(Venta.class);

        Estadisticas estadisticas = new Estadistica(baseDeDatos);

        Mockito.when(venta.getFecha()).thenReturn("01/05/2017");
        Mockito.when(venta.getCantidad()).thenReturn(1);
        Mockito.when(venta.getPrecioUnidad()).thenReturn(0.0);

        ArrayList<Venta> ventasMes= new ArrayList<>();
        ventasMes.add(venta);
        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventasMes);



        String resultado = estadisticas.histogramaVentasMes();



        Assert.assertEquals(""+
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "|                               \n" +
                "--------------------------------" , resultado);

    }

    @Test
    public void histogramaVentasMesConLaBBDDConDosVentasEsteMes() throws Exception {




        Venta venta1 = Mockito.mock(Venta.class);
        Mockito.when(venta1.getFecha()).thenReturn("31/05/2017");
        Mockito.when(venta1.getCantidad()).thenReturn(1);
        Mockito.when(venta1.getPrecioUnidad()).thenReturn(10.0);

        Venta venta2 = Mockito.mock(Venta.class);
        Mockito.when(venta2.getFecha()).thenReturn("01/05/2017");
        Mockito.when(venta2.getCantidad()).thenReturn(2);
        Mockito.when(venta2.getPrecioUnidad()).thenReturn(5.0);

        ArrayList<Venta> ventasMes= new ArrayList<>();
        ventasMes.add(venta1);
        ventasMes.add(venta2);

        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventasMes);

        Estadisticas estadisticas = new Estadistica(baseDeDatos);





        String resultado = estadisticas.histogramaVentasMes();




        Assert.assertEquals(""+
                "|                               \n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "|*                             *\n" +
                "--------------------------------" , resultado);

    }
}