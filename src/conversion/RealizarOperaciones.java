package conversion;

import java.io.IOException;

public class RealizarOperaciones extends Conversor {
    public String moneda;
    Double Dolar;
    Double PesoArgentino;
    Double RealBrasilero;
    String json;

    public RealizarOperaciones(TransformandoDatos transformandoDatos) throws IOException, InterruptedException {
        this.Dolar = Double.valueOf(transformandoDatos.usd());
        this.RealBrasilero = Double.valueOf(transformandoDatos.brl());
        this.PesoArgentino = Double.valueOf(transformandoDatos.ars());
    }

    public void mensaje() {
        System.out.printf("El valor del dolar es: %.2f ",this.Dolar);

    }

}
