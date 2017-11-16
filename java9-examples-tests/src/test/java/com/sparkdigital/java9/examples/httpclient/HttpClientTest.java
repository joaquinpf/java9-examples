package com.sparkdigital.java9.examples.httpclient;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class HttpClientTest {

    @Test
    public void oldClient() throws Exception {
        URL url = new URL("https://www.google.com/");

        //Create a connection to target URL
        URLConnection urlConnection = url.openConnection();

        // Create input stream and load into reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;

        // Loop through and output each line in stream.
        while ((inputLine = reader.readLine()) != null) {
            System.out.println(inputLine);
        }

        // Close the reader
        reader.close();
    }

    @Test
    public void newClient() throws Exception {
        // Note that the client classes are under jdk.incubator. These are not included in default Java SE so we need
        // to provide an extra javac/java option to include the module: --add-modules=jdk.incubator.httpclient

        // Create the client
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create the GET request
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("https://www.google.com/")).GET().build();

        // Get the response
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());

        // Print the body
        System.out.println(httpResponse.body());
    }

    @Test
    public void newClientAsync() throws Exception {
        // Create the client
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create the GET request
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("https://www.google.com/")).GET().build();

        // Get the response
        CompletableFuture<HttpResponse<String>> httpResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandler.asString());

        // Request could be cancelled in flight with httpResponse.cancel(...)

        // Wait for the request to complete and print the body
        System.out.println(httpResponse.get().body());
    }

    @Test
    public void newCLientPost() throws Exception {
        // Create the client
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create the POST request
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://httpbin.org/post")).POST(
                        HttpRequest.BodyProcessor.fromString("Post Body"))
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        // Send the request
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
        assertThat(httpResponse.statusCode()).isEqualTo(200);
    }

}
