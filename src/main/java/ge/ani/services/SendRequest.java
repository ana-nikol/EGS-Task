package ge.ani.services;
import io.cucumber.gherkin.internal.com.eclipsesource.json.Json;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SendRequest {
    final static String baseurl = "https://gorest.co.in/public/v2/";

    public String send_get_request(String url, boolean with_terminal_output) throws IOException {
        URL web_url = new URL(baseurl + url);
        StringBuilder response = new StringBuilder();
        HttpURLConnection conn = (HttpURLConnection) web_url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        int responseCode = conn.getResponseCode();
//        System.out.println("This is response code: " + responseCode);
        conn.connect();
        Scanner sc = new Scanner(web_url.openStream());
        while (sc.hasNext()) {
            response.append(sc.nextLine());
        }
        if (responseCode != 200) {
            response.append("HttpResponseCode: ").append(responseCode);
//            System.out.println(response);
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            printer(with_terminal_output, response.toString(),responseCode);
            sc.close();
        }

        return response.toString();
    }

    public String send_post_request(String url, boolean with_terminal_output, String data) throws IOException {
        URL web_url = new URL(baseurl + url);
        StringBuilder response = new StringBuilder();
        HttpURLConnection conn = (HttpURLConnection) web_url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + "77a8789a6dc2e5e2f52f31df698ca8dc44bf50041113638d8d2873a5bd5f1ed9");
        conn.setRequestMethod("POST");
//        System.out.println("data to write: "+data);
        conn.setDoOutput(true);
        try (OutputStream out = conn.getOutputStream()) {
            byte[] input = data.getBytes(StandardCharsets.UTF_8);
            out.write(input, 0, input.length);
        }
        int responseCode = conn.getResponseCode();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            //System.out.println(response.toString());
        }
//        System.out.println("This is response code: " + responseCode);
        if (responseCode != 200 && responseCode != 201) {
            response.append("HttpResponseCode: ").append(responseCode);
//            System.out.println(response);
            throw new RuntimeException("HttpResponseCode: " + responseCode);
        } else {
            printer(with_terminal_output, response.toString(), responseCode);
        }

        return response.toString();
    }
    public String send_delete_request(){
        return "Delete Request yet to be developed";
    }

    public String send_put_request(){
        return "Put Request yet to be developed";
    }

    private void printer(boolean print,String response, int responseCode){
        if(print){
            System.out.println("Server Response Code : "+responseCode);
            System.out.println("\nJSON data in string format");
            System.out.println("Response : "+response);
        }
    }
}