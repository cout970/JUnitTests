package ModuloImportacion;

import AccesoDatos.BaseDeDatos;
import AccesoDatos.Item;
import AccesoDatos.Usuario;
import AccesoDatos.Venta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Importador implements Importacion {

    @Override
    public BaseDeDatos leerFichero(String nombre) {
        String linea;
        Scanner sc = null;
        BaseDeDatos bdImportar = new BaseDeDatos();

        try {
            sc = new Scanner(new File(nombre));
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo " + nombre + " no encontrado");
        }

        while (sc.hasNext()) {
            linea = sc.nextLine();
            String campos[] = linea.split("; ");

            //Se comprueba si se trata de un usuario, un item o una venta
            switch (campos[0]) {
                case "U":
                    bdImportar.obtenerUsuarios().add(new Usuario(campos[1], campos[2], campos[3], campos[4], campos[5]));
                    break;
                case "I":
                    bdImportar.obtenerItems().add(new Item(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]), campos[6]));
                    break;
                case "V":
                    bdImportar.obtenerVentas().add(new Venta(campos[1], campos[2], campos[3], campos[4], Integer.parseInt(campos[5]), Double.parseDouble(campos[6])));
                    break;
            }
        }

        return bdImportar;
    }

}