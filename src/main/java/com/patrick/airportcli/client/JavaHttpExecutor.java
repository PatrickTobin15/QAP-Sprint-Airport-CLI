package com.patrick.airportcli.client;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaHttpExecutor implements HttpExecutor {

    private final HttpClient httpClient;

    public JavaHttpExecutor() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @Override
    public String get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 400) {
            throw new IOException("Request to " + url + " failed with status " + response.statusCode());
        }

        return response.body();
    }
}
