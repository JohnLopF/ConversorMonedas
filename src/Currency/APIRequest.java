package Currency;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class APIRequest {

    public double getExchangeRate(String monedaInicial, String monedaFinal) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://v6.exchangerate-api.com/v6/d2380988bc88e7cc024e381e/latest/" + monedaInicial;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        // Parsear la respuesta del JSON
        Gson gson = new Gson();
        JsonObject conversionRateData = gson.fromJson(json, JsonObject.class);

        // Respuesta de éxito al extraer los datos
        if (conversionRateData.get("result").getAsString().equals("success")) {
            // Extraer los datos de conversión
            JsonObject conversionRates = conversionRateData.getAsJsonObject("conversion_rates");


            if (monedaInicial.equals(conversionRateData.get("base_code").getAsString())) {
                return conversionRates.get(monedaFinal).getAsDouble();
            } else {

                double baseRate = conversionRates.get(monedaInicial).getAsDouble();
                double targetRate = conversionRates.get(monedaFinal).getAsDouble();
                return targetRate / baseRate;
            }
        } else {

            throw new RuntimeException("Failed to retrieve exchange rate. Error: " + conversionRateData.get("error").getAsString());
        }

    }
}