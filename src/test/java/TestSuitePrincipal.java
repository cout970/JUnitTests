import AccesoDatos.DarDeBajaUsuario;
import AccesoDatos.IntroducirItem;
import AccesoDatos.IntroducirUsuario;
import AccesoDatos.IntroducirVenta;
import ModuloEstadistico.HistogramaDeVentasDiariasEnElUltimoMes;
import ModuloEstadistico.NumeroMedioVentasAlDiaEnElUltimoMes;
import ModuloEstadistico.PorcentajeDeVentasDiariasSobreElTotalDelMes;
import ModuloEstadistico.VentasEnElUltimoAno;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by cout970 on 5/12/17.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        IntroducirItem.class,
        IntroducirUsuario.class,

        DarDeBajaUsuario.class,
        IntroducirVenta.class,

        HistogramaDeVentasDiariasEnElUltimoMes.class,
        NumeroMedioVentasAlDiaEnElUltimoMes.class,

        PorcentajeDeVentasDiariasSobreElTotalDelMes.class,
        VentasEnElUltimoAno.class
})
public class TestSuitePrincipal {}
