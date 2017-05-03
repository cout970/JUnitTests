package ModuloEstadistico;

import AccesoDatos.Venta;

import java.util.ArrayList;

public interface Estadisticas {
    public double ventasSemana();

    public double ventasMes();

    public double ventasAno();

    public double mediaVentasMes();

    public double mediaVentasAno();

    public String histogramaVentasMes();

    public String histogramaVentasAno();

    public String porcentajeVentasMes();

    public String porcentajeVentasAno();

    public ArrayList<Venta> obtenerVentasSemana();

    public ArrayList<Venta> obtenerVentasMes();

    public ArrayList<Venta> obtenerVentasAno();
}
