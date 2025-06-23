package conversion;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.IOException;

public class RealizarOperaciones extends Conversor {
    public String moneda;
    Double Dolar;
    Double PesoArgentino;
    Double RealBrasilero;
    Double SolPeruano;
    Double PesoColombiano;
    String json;

    public RealizarOperaciones(TransformandoDatos transformandoDatos) {
        this.Dolar = Double.valueOf(transformandoDatos.USD());
        this.PesoArgentino = Double.valueOf(transformandoDatos.ARS());
        this.RealBrasilero = Double.valueOf(transformandoDatos.BRL());
        this.SolPeruano = Double.valueOf(transformandoDatos.PEN());
        this.PesoColombiano = Double.valueOf(transformandoDatos.COP());
    }

    public double conversion(int numero, double cantidad) {
        Double transformar = switch (numero) {
            case 1 -> cantidad * (SolPeruano / Dolar);
            case 2 -> cantidad * (Dolar / SolPeruano);
            case 3 -> cantidad * (PesoArgentino / Dolar);
            case 4 -> cantidad * (Dolar / PesoArgentino);
            case 5 -> cantidad * (RealBrasilero / Dolar);
            case 6 -> cantidad * (Dolar / RealBrasilero);
            case 7 -> cantidad * (PesoColombiano / Dolar);
            case 8 -> cantidad * (Dolar / PesoColombiano);
            default -> -1.0;
        };
        return transformar;
    }
}