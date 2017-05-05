package AccesoDatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by petrusboniatus on 5/3/17.
 */
public class IntroducirUsuario {

    private BaseDatos baseDatos;

    private List<Usuario> clonarUsuarios() {
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


    @Before
    public void setup() {
        baseDatos = new BaseDeDatos();
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
    public void anadirUsuarioConIdInvalida() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-00",
                "10000002X",
                "nombre.apellido1@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario id invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con id invalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConIdNulo() throws Exception {

        Usuario user = new Usuario(
                null,
                "10000002X",
                "nombreN1.apellido1@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con id nulo no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con id nulo en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConDNIInvalido() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-002",
                "10000003-X",
                "nombre.apellido2@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con dni invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con dni invalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConDNINulo() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-002",
                null,
                "nombre.apellido2@rai.usc.es",
                "Ceferino",
                "Lopez Dominguez",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con dni nulo no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con dni nulo en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConStringCorreoVacio() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-003",
                "10000004A",
                "",
                "Julián",
                "Flores González",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con dni vacio no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con dni vacio en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConCorreoInvalido() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-003",
                "10000004A",
                "eduardodocenciaUSC@gmail.com",
                "Julián",
                "Flores González",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con un email de dominio invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con email de dominio invalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );
    }

    @Test
    public void anadirUsuarioConCorreoNulo() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-003",
                "10000004N",
                null,
                "Julián",
                "Flores González",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con un email nulo no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con email nulo en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConNombreInvalido() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-004",
                "10000005A",
                "nombre.apellido4@rai.usc.es",
                "xXx_Mia_xXx",
                "Cal Ifa",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con un nombre con formato invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con nombre con formato ivalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );


    }

    @Test
    public void anadirUsuarioConApellidoInvalido() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-005",
                "10000006A",
                "nombre.apellido5@rai.usc.es",
                "Adolfo",
                "Bueno_Malo",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con un apellido ilustre con formato invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con apellido con formato ivalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConFechaEnFormatoInvalido() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-006",
                "10000007A",
                "nombre.apellido@rai.usc.es",
                "Adolfo",
                "Bueno Malo",
                "01-01-1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con fecha con formato invalido no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un usuario con fecha con formato ivalido en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConFechaEnElFuturo() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-007",
                "10000001H",
                "marty.mcfly@rai.usc.es",
                "Marty",
                "McFly Ravenson",
                "01/01/1987",
                "01/01/2016",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario con fecha de nacimiento en el futuro no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido inpunemente un viajero del tiempo en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioConFechaAnteriorA1970() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-012",
                "10000001B",
                "johny.sins@rai.usc.es",
                "Johny",
                "Sins Ravenson",
                "01/01/1969",
                "01/01/2016",
                true
        );

        baseDatos.anadirUsuario(user);

        assertEquals(1, baseDatos.obtenerUsuarios().size());
        assertEquals(user, baseDatos.obtenerUsuarios().get(0));

    }

    @Test
    public void anadirUsuarioConFechaRegistroAnteriorAFechaNacimiento() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-013",
                "10000002B",
                "ignacio.allende@rai.usc.es",
                "Ignacio",
                "Allende Fernández",
                "01/01/1969",
                "01/01/1921",
                true
        );
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir un usuario que se ha registrado antes de nacer no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido un dantesco ser que transgrede las dimensiones temporales " +
                        "(fecha de registro anterior a nacimiento) en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }

    @Test
    public void anadirUsuarioYaRegistradoEnElSistema() throws Exception {

        Usuario user = new Usuario(
                "U-ABCDE-014",
                "10000002B",
                "edrop.eunoby@rai.usc.es",
                "Edrop",
                "Eunob Dreyla",
                "01/01/1987",
                "01/01/2016",
                true
        );
        baseDatos.anadirUsuario(user);
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user);
            fail("Anñadir el mismo usuario 2 veces no ha provocado una excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se ha introducido inpunemente un viajero del tiempo en la bd",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );
    }

    @Test
    public void anadirUsuarioConNombreYaRegistrado() throws Exception {

        Usuario user1 = new Usuario(
                "U-ABCDE-000",
                "10000013A",
                "edrop.eunoby@rai.usc.es",
                "Edrop",
                "Eunob Dreyla",
                "01/01/1987",
                "01/01/2016",
                true
        );
        Usuario user2 = new Usuario(
                "U-ABCDE-010",
                "10000013C",
                "edrop.eunoby2@rai.usc.es",
                "Edrop",
                "Eunob Dreyla",
                "01/01/1987",
                "01/01/2016",
                true
        );
        baseDatos.anadirUsuario(user1);


        baseDatos.anadirUsuario(user2);


        List<Usuario> usuariosActuales = baseDatos.obtenerUsuarios();
        List<Usuario> usuariosEsperados = Arrays.asList(user1, user2);
        Assert.assertTrue(
                usuariosActuales.containsAll(usuariosEsperados)
                        && usuariosEsperados.containsAll(usuariosActuales)
        );
    }

    @Test
    public void anadirUsuarioConCorreoYaRegistrado() throws Exception {

        Usuario user1 = new Usuario(
                "U-ABCDE-027",
                "100000023P",
                "edrop.eunoby@rai.usc.es",
                "Edrop",
                "Eunob Dreyla",
                "01/01/1987",
                "01/01/2016",
                true
        );
        Usuario user2 = new Usuario(
                "U-ABCDE-026",
                "100000023C",
                "edrop.eunoby@rai.usc.es",
                "Edrop",
                "Eunob Dreyla",
                "01/01/1987",
                "01/01/2016",
                true
        );
        baseDatos.anadirUsuario(user1);
        List<Usuario> usuariosAntiguos = clonarUsuarios();


        try {
            baseDatos.anadirUsuario(user2);
            fail("Anñadir un usuario con el mismo correo que otro no ha provocado ninguna excepción");
        } catch (Exception e) {
            /*Ejecución normal del programa*/
        }


        Assert.assertEquals(
                "Se han añadido en la base de datos dos usuarios con el mismo correo electrónico",
                usuariosAntiguos,
                baseDatos.obtenerUsuarios()
        );

    }
}