package principal;

import Lista.RegistroConversiones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import conversion.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lec = new Scanner(System.in);
        Gson gson = new GsonBuilder().create();
        Conversor conversor = new Conversor();
        String json = conversor.convercion("USD");
        ApiResponse respuesta = gson.fromJson(json, ApiResponse.class);
        TransformandoDatos datos = respuesta.conversion_rates();
        RealizarOperaciones realizar = new RealizarOperaciones(datos);
        RegistroConversiones registro = new RegistroConversiones();

        String mensaje = """
                *----Bienvenido al conversor de monedas----*
                1) Dólar --> Sol Peruano
                2) Sol Peruano --> Dólar
                3) Dólar --> Peso Argentino
                4) Peso Argentino --> Dólar
                5) Dólar --> Real Brasileño
                6) Real Brasileño --> Dólar
                7) Dólar --> Peso Colombiano
                8) Peso Colombiano --> Dólar
                9) Salir
                ----* Elija una opción válida *----
                """;

        int numero = 0;
        double cantidad = 0.0;

        do {
            try {
                do {
                    System.out.print(mensaje);
                    numero = lec.nextInt();
                    if (numero < 0 || numero > 9) {
                        System.out.println(" Error: ingrese un número dentro del rango correcto");
                    }
                } while (numero < 0 || numero > 9);

                if (numero == 9) break;

                System.out.print("Ingrese la cantidad que va a convertir: ");
                cantidad = lec.nextDouble();

                double resultado = realizar.conversion(numero, cantidad);
                String mostrar = "";

                switch (numero) {
                    case 1 -> {
                        registro.registrar("Dólar a Sol Peruano", cantidad);
                        mostrar = String.format("Su cantidad ingresada en $%.2f es %.2f Soles", cantidad, resultado);
                    }
                    case 2 -> {
                        registro.registrar("Sol Peruano a Dólar", cantidad);
                        mostrar = String.format("Su cantidad ingresada en S/%.2f es %.2f Dólares", cantidad, resultado);
                    }
                    case 3 -> {
                        registro.registrar("Dólar a Peso Argentino", cantidad);
                        mostrar = String.format("Su cantidad ingresada en $%.2f es %.2f Pesos Argentinos", cantidad, resultado);
                    }
                    case 4 -> {
                        registro.registrar("Peso Argentino a Dólar", cantidad);
                        mostrar = String.format("Su cantidad ingresada en ARS %.2f es %.2f Dólares", cantidad, resultado);
                    }
                    case 5 -> {
                        registro.registrar("Dólar a Real Brasileño", cantidad);
                        mostrar = String.format("Su cantidad ingresada en $%.2f es %.2f Reales", cantidad, resultado);
                    }
                    case 6 -> {
                        registro.registrar("Real Brasileño a Dólar", cantidad);
                        mostrar = String.format("Su cantidad ingresada en BRL %.2f es %.2f Dólares", cantidad, resultado);
                    }
                    case 7 -> {
                        registro.registrar("Dólar a Peso Colombiano", cantidad);
                        mostrar = String.format("Su cantidad ingresada en $%.2f es %.2f Pesos Colombianos", cantidad, resultado);
                    }
                    case 8 -> {
                        registro.registrar("Peso Colombiano a Dólar", cantidad);
                        mostrar = String.format("Su cantidad ingresada en COL %.2f es %.2f Dólares", cantidad, resultado);
                    }
                }

                System.out.println(mostrar);

            } catch (InputMismatchException e) {
                System.out.println(" Error: Ingresaste un valor no numérico. Inténtalo de nuevo.");
                lec.nextLine(); // Limpia el buffer del Scanner
            }

        } while (numero != 9);

        registro.mostrarResumen();
        System.out.println("--Saliendo del programa--");
    }
}