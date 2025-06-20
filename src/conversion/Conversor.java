package conversion;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public String moneda;
    Double Dolar;
    Double PesoArgentino;
    Double RealBrasilero;
    String json;

    public Conversor(TransformandoDatos transformandoDatos) throws IOException, InterruptedException {
        Dolar = Double.valueOf(transformandoDatos.usd());
        RealBrasilero = Double.valueOf(transformandoDatos.brl());
        PesoArgentino = Double.valueOf(transformandoDatos.ars());
    }

    public void convercion(String tipoDemoneda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/c435e52cae63aac78a5345d9/latest/+tipoDemoneda+")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
    }
    Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
    TransformandoDatos Transformar = gson.fromJson(json,TransformandoDatos.class);
}
