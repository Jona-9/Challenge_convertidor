package Lista;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RegistroConversiones {
    private Map<String, List<Double>> historial;

    public RegistroConversiones() {
        historial = new HashMap<>();
    }
    public void registrar(String tipo, double monto) {
        historial.putIfAbsent(tipo, new ArrayList<>());
        historial.get(tipo).add(monto);
    }
    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DE CONVERSIONES ---");
        for (String tipo : historial.keySet()) {
            List<Double> montos = historial.get(tipo);
            double suma = montos.stream().mapToDouble(Double::doubleValue).sum();
            double promedio = suma / montos.size();
            System.out.printf("%s: %d conversiones - Promedio: %.2f\n",
                    tipo, montos.size(), promedio);
        }
    }
}
