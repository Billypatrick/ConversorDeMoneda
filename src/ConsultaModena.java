import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaModena {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/03ffd5943bd7bb8578c48444/pair";

    public MonedaAPI buscaMoneda(String monedaBase, String monedaSecundaria) {
        URI direccion = URI.create(String.format("%s/%s/%s", API_URL, monedaBase, monedaSecundaria));

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return new Gson().fromJson(response.body(), MonedaAPI.class);
            } else {
                throw new RuntimeException("Error al obtener los datos de la API. Código HTTP: " + response.statusCode());
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la API: " + e.getMessage());
        }
    }
}
