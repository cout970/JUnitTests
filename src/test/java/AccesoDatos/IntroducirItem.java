package AccesoDatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Couto
 */
public class IntroducirItem {

    private BaseDatos baseDatos;

    @Before
    public void setup(){
        baseDatos =  new BaseDeDatos();
    }

    @Test
    public void anadirItemValido() throws Exception {}
    @Test
    public void anadirItemConIdInvalido() throws Exception {}
    @Test
    public void anadirItemConCategoriaInvalida() throws Exception {}
    @Test
    public void anadirItemConIdEnMayusculasYMinusculas() throws Exception {}
    @Test
    public void anadirItemConNombreInvalido() throws Exception {}
    @Test
    public void anadirItemConFechaEnElMarabillosoFuturoDe2038() throws Exception {}
    @Test
    public void anadirItemConFormatoDeFechaInvalido() throws Exception {}
    @Test
    public void anadirItemConStockNegativo() throws Exception {}

    @Test
    public void anadirItemConStockConPuntoFlotante() throws Exception {
        Item item = Mockito.mock(Item.class);

        Mockito.when(item.getStock()).thenReturn(Float.floatToIntBits(4.20f));

        baseDatos.anadirItem(item);

        Assert.assertEquals(1, baseDatos.obtenerItems().size());
    }

    @Test
    public void anadirItemYaExistente() throws Exception {}
}
