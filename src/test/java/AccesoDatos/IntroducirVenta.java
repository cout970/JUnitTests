package AccesoDatos;

import org.junit.Test;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Couto
 */
public class IntroducirVenta {

    @Test
    public void anadirVentaValida() throws Exception {}
    @Test
    public void anadirVentaConIdInvalida() throws Exception {}
    @Test
    public void anadirVentaConIdNulo() throws Exception {}
    @Test
    public void anadirVentaConFormatoInvalidoDeFecha() throws Exception {}
    @Test
    public void anadirVentaConFechaNula() throws Exception {}
    @Test
    public void anadirVentaConCantidadNegativa() throws Exception {}
    @Test
    public void anadirVentaConPrecioUnitarioNegativo() throws Exception {}
    @Test
    public void anadirVentaConPrecioUnitarioCero() throws Exception {}
    @Test
    public void anadirVentaConIdDeUsuarioConFormatoInvalido() throws Exception {}
    @Test
    public void anadirVentaConIdDeItemConFormatoInvalido() throws Exception {}
    @Test
    public void anadirVentaConFechaDelFuturo() throws Exception {}
    @Test
    public void anadirVentaConFechaAnteriorA1970() throws Exception {}
    @Test
    public void anadirVentaDosVeces() throws Exception {}
}
