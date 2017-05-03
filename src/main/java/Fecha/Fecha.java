package Fecha;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
    DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    public String toString(Date fechaD) {
        return formato.format(fechaD);
    }

    public Date toDate(String fechaS) {
        Date fechaD = null;
        try {
            fechaD = formato.parse(fechaS);
        } catch (ParseException ex) {
            System.out.println("Error: Formato de Fecha incorrecto");
        }
        return fechaD;
    }
}
