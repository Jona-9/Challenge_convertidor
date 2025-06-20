package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversion.Conversor;
import conversion.RealizarOperaciones;
import conversion.TransformandoDatos;

import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        Conversor conversor = new Conversor();
        TransformandoDatos Transformar = gson.fromJson(conversor.convercion("usd"),TransformandoDatos.class);
        RealizarOperaciones realizarOperaciones = new RealizarOperaciones(Transformar);
        realizarOperaciones.mensaje();
    }
}