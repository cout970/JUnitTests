package AccesoDatos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cout970 on 5/3/17.
 *
 * TODO Pedro
 */
public class IntroducirUsuario {

    private BaseDatos baseDatos;

    @Before
    public void setup(){
        baseDatos =  new BaseDeDatos();
    }

    @Test
    public void anadirUsuarioConClaveValida() throws Exception {

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

        baseDatos.anadirUsuario(user);

        assertEquals(1, baseDatos.obtenerUsuarios().size());
        assertEquals(user, baseDatos.obtenerUsuarios().get(0));
    }

    @Test
    public void anadirUsuarioConIdInvalida() throws Exception {}
    @Test
    public void anadirUsuarioConIdNulo() throws Exception {}
    @Test
    public void anadirUsuarioConDNIInvalido() throws Exception {}
    @Test
    public void anadirUsuarioConDNINulo() throws Exception {}
    @Test
    public void anadirUsuarioConStringCorreoVacio() throws Exception {}
    @Test
    public void anadirUsuarioConCorreoInvalido() throws Exception {}
    @Test
    public void anadirUsuarioConCorreoNulo() throws Exception {}
    @Test
    public void anadirUsuarioConNombreInvalido() throws Exception {}
    @Test
    public void anadirUsuarioConApellidoInvalido() throws Exception {}
    @Test
    public void anadirUsuarioConFechaEnFormatoInvalido() throws Exception {}
    @Test
    public void anadirUsuarioConFechaEnElFuturo() throws Exception {}
    @Test
    public void anadirUsuarioConFechaAnteriorA1970() throws Exception {}
    @Test
    public void anadirUsuarioConFechaRegistroAnteriorAFechaNacimiento() throws Exception {}
    @Test
    public void anadirUsuarioYaRegistradoEnElSistema() throws Exception {}
    @Test
    public void anadirUsuarioConNombreYaRegistrado() throws Exception {}
    @Test
    public void anadirUsuarioConCorreoYaRegistrado() throws Exception {}
}