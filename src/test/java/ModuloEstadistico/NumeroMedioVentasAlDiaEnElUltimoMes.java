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

import org.junit.Assert;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Pedro
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ Calendar.class })
public class NumeroMedioVentasAlDiaEnElUltimoMes {

    @Before
    public void setup(){

        Calendar fechaPrueba = Calendar.getInstance();
        fechaPrueba.set(2017,Calendar.MAY,31);

        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(fechaPrueba);

        Assert.assertEquals(fechaPrueba,Calendar.getInstance());
    }

    @Test
    public void mediaVentasMesConBBDDVacia() throws Exception {

        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Estadistica estadistica = new Estadistica(baseDeDatos);


        double media = estadistica.mediaVentasMes();


        Assert.assertEquals(0.0, media,Double.MIN_VALUE*10);

    }

    @Test
    public void meaidVentasMesConBBDDConUnaVenta() throws Exception {

        Venta venta = Mockito.mock(Venta.class);
        Mockito.when(venta.getFecha()).thenReturn("01/05/2017");
        Mockito.when(venta.getCantidad()).thenReturn(1);
        Mockito.when(venta.getPrecioUnidad()).thenReturn(100.0);

        ArrayList<Venta> ventasMes= new ArrayList<>();
        ventasMes.add(venta);
        BaseDatos baseDeDatos = Mockito.mock(BaseDeDatos.class);
        Mockito.when(baseDeDatos.obtenerVentas()).thenReturn(ventasMes);

        Estadistica estadistica = new Estadistica(baseDeDatos);


        double media = estadistica.mediaVentasMes();


        Assert.assertEquals(0.03, media, Double.MIN_VALUE*10);

    }
}
