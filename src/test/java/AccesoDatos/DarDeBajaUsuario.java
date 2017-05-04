package AccesoDatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.fail;

/**
 * Created by petrusboniatus on 5/3/17.
 *
 */
public class DarDeBajaUsuario {

    private BaseDatos baseDatos;

    @Before
    public void setup(){
        baseDatos =  new BaseDeDatos();
        Usuario usuarioIntroducido = new Usuario(
                "U-ABCDE-005",
                "10000000X",
                "nombre.apellido@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );
        baseDatos.anadirUsuario(usuarioIntroducido);
    }

    private List<Usuario> clonarUsuarios(){
        return baseDatos.obtenerUsuarios()
                .stream()
                .map(u -> new Usuario(
                        u.getIdUsuario(),
                        u.getDni(),
                        u.getCorreoElectronico(),
                        u.getNombre(),
                        u.getApellidos(),
                        u.getFechaNacimiento(),
                        u.getFechaAlta(),
                        u.isEstaActivo()
                ))
                .collect(Collectors.toList());
    }

    @Test
    public void darBajaUsuarioConIdValida() throws Exception {


        baseDatos.darBajaUsuario("U-ABCDE-005");


        Usuario usuarioRecuperado = baseDatos.obtenerUsuario("U-ABCDE-005");
        Assert.assertFalse(usuarioRecuperado.isEstaActivo());

    }
    @Test
    public void darBajaUsuarioDosVeces() throws Exception {

        baseDatos.darBajaUsuario("U-ABCDE-005");


        try {
            baseDatos.darBajaUsuario("U-ABCDE-005");
            fail("No ha lanzando una excepción al intentar dar de baja el usuario 2 veces");
        }catch (Exception e){
            /*La ejecución pasando los test es por aquí*/
        }


        Usuario usuarioRecuperado = baseDatos.obtenerUsuario("U-ABCDE-005");
        Assert.assertFalse(usuarioRecuperado.isEstaActivo());

    }
    @Test
    public void darBajaUsuarioConIdNulo() throws Exception {

        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.darBajaUsuario(null);
            fail("No ha lanzando una excepción al intentar dar de baja un id con usuario nulo");
        }catch (Exception e){
            /*La ejecución pasando los test es por aquí*/
        }


        Assert.assertEquals("El estado de la bd ha cambiado",usuariosAntiguos, baseDatos.obtenerUsuarios());

    }
    @Test
    public void darBajaUsuarioConIdInvalida() throws Exception {

        List<Usuario> usuariosAntiguos = clonarUsuarios();

        try {
            baseDatos.darBajaUsuario("U-ABCDE-00");
            fail("No ha lanzando una excepción al intentar dar de baja un id con formato invalido");
        }catch (Exception e){
            /*La ejecución pasando los test es por aquí*/
        }


        Assert.assertEquals("El estado de la bd ha cambiado", usuariosAntiguos, baseDatos.obtenerUsuarios());
    }

}
