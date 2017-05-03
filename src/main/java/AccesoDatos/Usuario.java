package AccesoDatos;

import Fecha.Fecha;

import java.util.Date;

public class Usuario {

    private String idUsuario;
    private String dni;
    private String correoElectronico;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private Date fechaAlta;
    private boolean estaActivo;
    private final Fecha cFecha = new Fecha();

    public Usuario() {
        estaActivo = true;
    }

    public Usuario(String idUsuario, String fechaAlta, String nombre, String apellidos, String dni) {
        this.fechaAlta = cFecha.toDate(fechaAlta);
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estaActivo = true;
    }

    public Usuario(String idUsuario, String dni, String correoElectronico, String nombre, String apellidos, String fechaNacimiento, String fechaAlta, boolean estaActivo) {
        this.fechaAlta = cFecha.toDate(fechaAlta);
        this.fechaNacimiento = cFecha.toDate(fechaNacimiento);
        this.idUsuario = idUsuario;
        this.dni = dni;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estaActivo = estaActivo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return cFecha.toString(fechaNacimiento);
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = cFecha.toDate(fechaNacimiento);
    }

    public String getFechaAlta() {
        return cFecha.toString(fechaAlta);
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = cFecha.toDate(fechaAlta);
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

}