package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class RequestFinalValue {
    public String getFinalValue(String optionToConvert, String optionToBeConverted, String valueToConvert) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://economia.awesomeapi.com.br/last/" + optionToConvert + '-' + optionToBeConverted))
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        try {
            int intValue = Integer.parseInt(valueToConvert);
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonObject = new Gson().fromJson(response.body().toString(), JsonObject.class);
            double numberOne = Double.parseDouble(jsonObject.get(optionToConvert + optionToBeConverted).getAsJsonObject().get("ask").getAsString());
            double result = numberOne * intValue;

            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            return decimalFormat.format(result);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
