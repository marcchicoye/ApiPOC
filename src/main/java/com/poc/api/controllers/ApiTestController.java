package com.poc.api.controllers;

import java.io.*;
import java.net.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiTestController {

    @GetMapping("/")
    public String getApi() {

        StringBuilder result = new StringBuilder();

        try {

            URL url = new URL("https://random-data-api.com/api/v2/users?size=1&response_type=json");            

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");


            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        // close the connection
        connection.disconnect();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

        }
        
        // you can use one of these methods to get the results
        // connection.connect();
        // connection.getResponseCode();
        // connection.getInputStream();
        // connection.getOutputStream();

        
        return result.toString();
    }
    
}
