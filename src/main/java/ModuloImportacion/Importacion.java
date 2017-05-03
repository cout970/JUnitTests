package ModuloImportacion;

import AccesoDatos.BaseDeDatos;

public interface Importacion {
    public BaseDeDatos leerFichero(String nombre);
}