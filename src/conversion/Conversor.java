package conversion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    static HttpClient client = HttpClient.newHttpClient();
    static HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/c435e52cae63aac78a5345d9/latest/USD")).build();
    static HttpResponse<String> response;

    static {
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Conversor() throws IOException, InterruptedException {
    }

    public static void main(String[] args) {
        System.out.println(response.body());
    }
}
