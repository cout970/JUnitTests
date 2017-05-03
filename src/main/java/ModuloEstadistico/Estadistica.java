package ModuloEstadistico;

import AccesoDatos.BaseDatos;
import AccesoDatos.Venta;
import Fecha.Fecha;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;

public class Estadistica implements Estadisticas {

    private final BaseDatos bd;
    private final Fecha cFecha;

    public Estadistica(BaseDatos bd) {
        this.bd = bd;
        cFecha = new Fecha();
    }


    @Override
    public double ventasSemana() {
        ArrayList<Venta> ventas = obtenerVentasSemana();
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            total += ventas.get(i).getPrecioUnidad();
        }
        return total;
    }

    @Override
    public double ventasMes() {
        ArrayList<Venta> ventas = obtenerVentasMes();
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            total += ventas.get(i).getPrecioUnidad();
        }
        return total;
    }

    @Override
    public double ventasAno() {
        ArrayList<Venta> ventas = obtenerVentasAno();
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            total += ventas.get(i).getPrecioUnidad();
        }
        return total;
    }

    @Override
    public double mediaVentasMes() {
        Calendar currentCalendar = Calendar.getInstance();
        ArrayList<Venta> ventas = obtenerVentasMes();
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            total += ventas.get(i).getPrecioUnidad();
        }
        return BigDecimal.valueOf(total / currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public double mediaVentasAno() {
        ArrayList<Venta> ventas = obtenerVentasAno();
        double total = 0;
        for (int i = 0; i < ventas.size(); i++) {
            total += ventas.get(i).getPrecioUnidad();
        }
        return BigDecimal.valueOf(total / 52).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String histogramaVentasMes() {
        ArrayList<Venta> ventas = obtenerVentasMes();
        Calendar currentCalendar = Calendar.getInstance();
        int columnas = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        double precios[] = new double[columnas];
        double porcentaje[] = new double[columnas];
        double max = 0;
        String histograma = "";


        //recopila precios por dia
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            precios[targetCalendar.get(Calendar.DAY_OF_MONTH)] += v.getPrecioUnidad();
        }

        double altura = 10;
        //calcula los asteriscos que va a necesitar
        for (int i = 0; i < columnas; i++) {
            if (precios[i] > max)
                max = precios[i];
        }
        for (int i = 0; i < columnas; i++) {
            porcentaje[i] = precios[i] / max * altura;
        }

        //marca cuando es necesario
        for (double j = altura; j >= 0; j--) {
            histograma += "|";
            for (int i = 0; i < columnas; i++) {
                if (porcentaje[i] > j) {
                    histograma += "*";
                } else {
                    histograma += " ";
                }
            }
            histograma += "\n";
        }
        for (int i = 0; i < columnas + 1; i++) {
            histograma += "-";
        }

        return histograma;
    }

    @Override
    public String histogramaVentasAno() {
        ArrayList<Venta> ventas = obtenerVentasAno();
        Calendar currentCalendar = Calendar.getInstance();
        int columnas = currentCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
        double precios[] = new double[columnas];
        double porcentaje[] = new double[columnas];
        double max = 0;
        String histograma = "";


        //recopila precios por semana
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            precios[targetCalendar.get(Calendar.WEEK_OF_YEAR)] += v.getPrecioUnidad();
        }

        double altura = 10;
        //calcula los asteriscos que va a necesitar
        for (int i = 0; i < columnas; i++) {
            if (precios[i] > max)
                max = precios[i];
        }
        for (int i = 0; i < columnas; i++) {
            porcentaje[i] = precios[i] / max * altura;
        }

        //marca cuando es necesario
        for (double j = altura; j >= 0; j--) {
            histograma += "|";
            for (int i = 0; i < columnas; i++) {
                if (porcentaje[i] > j) {
                    histograma += "*";
                } else {
                    histograma += " ";
                }
            }
            histograma += "\n";
        }
        for (int i = 0; i < columnas + 1; i++) {
            histograma += "-";
        }

        return histograma;
    }

    @Override
    public String porcentajeVentasMes() {
        String porcentajeVentas = "";
        ArrayList<Venta> ventas = obtenerVentasAno();
        Calendar currentCalendar = Calendar.getInstance();
        int columnas = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        double precios[] = new double[columnas];
        double total = 0;

        //recopila precios por dia
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            precios[targetCalendar.get(Calendar.DAY_OF_MONTH)] += v.getPrecioUnidad();
            total += v.getPrecioUnidad();
        }

        //calcula los porcentajes
        for (int i = 0; i < columnas; i++) {
            if (precios[i] > 0)
                porcentajeVentas += "Día " + (i + 1) + ": " + BigDecimal.valueOf(precios[i] / total * 100).setScale(2, RoundingMode.HALF_UP).doubleValue() + "%\n";
        }
        return porcentajeVentas;
    }

    @Override
    public String porcentajeVentasAno() {
        String porcentajeVentas = "";
        ArrayList<Venta> ventas = obtenerVentasAno();
        Calendar currentCalendar = Calendar.getInstance();
        int columnas = currentCalendar.getActualMaximum(Calendar.WEEK_OF_YEAR);
        double precios[] = new double[columnas];
        double total = 0;

        //recopila precios por semana
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            precios[targetCalendar.get(Calendar.WEEK_OF_YEAR)] += v.getPrecioUnidad();
            total += v.getPrecioUnidad();
        }

        //calcula los porcentajes
        for (int i = 0; i < columnas; i++) {
            if (precios[i] > 0)
                porcentajeVentas += "Semana " + (i + 1) + ": " + BigDecimal.valueOf(precios[i] / total * 100).setScale(2, RoundingMode.HALF_UP).doubleValue() + "%\n";
        }
        return porcentajeVentas;
    }

    @Override
    public ArrayList<Venta> obtenerVentasSemana() {
        ArrayList<Venta> ventas = bd.obtenerVentas();
        ArrayList<Venta> ventasL = new ArrayList<Venta>();

        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
            int targetYear = targetCalendar.get(Calendar.YEAR);
            if (week == targetWeek && year == targetYear) {
                ventasL.add(v);
            }
        }
        return ventasL;
    }

    @Override
    public ArrayList<Venta> obtenerVentasMes() {
        ArrayList<Venta> ventas = bd.obtenerVentas();
        ArrayList<Venta> ventasL = new ArrayList<Venta>();

        Calendar currentCalendar = Calendar.getInstance();
        int month = currentCalendar.get(Calendar.MONTH);
        int year = currentCalendar.get(Calendar.YEAR);
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            int targetMonth = targetCalendar.get(Calendar.MONTH);
            int targetYear = targetCalendar.get(Calendar.YEAR);
            if (month == targetMonth && year == targetYear) {
                ventasL.add(v);
            }
        }
        return ventasL;
    }

    @Override
    public ArrayList<Venta> obtenerVentasAno() {
        ArrayList<Venta> ventas = bd.obtenerVentas();
        ArrayList<Venta> ventasL = new ArrayList<Venta>();

        Calendar currentCalendar = Calendar.getInstance();
        int year = currentCalendar.get(Calendar.YEAR);
        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);
            Calendar targetCalendar = Calendar.getInstance();
            targetCalendar.setTime(cFecha.toDate(v.getFecha()));
            int targetYear = targetCalendar.get(Calendar.YEAR);
            if (year == targetYear) {
                ventasL.add(v);
            }
        }
        return ventasL;
    }

}
