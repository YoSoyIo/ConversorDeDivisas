import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionDeDivisa {
    public Divisa retornaInformacionDivisa(String divisa_base, String divisa_objetivo, double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/230a2b6266135f6fd397aa5d/pair/"+divisa_base+"/"+divisa_objetivo+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisa.class);
        } catch (Exception e) {
            throw new RuntimeException("No existe dicha divisa.");
        }
    }
}
