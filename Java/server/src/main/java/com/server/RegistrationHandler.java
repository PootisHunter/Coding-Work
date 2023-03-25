package com.server;
import java.io.IOException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class RegistrationHandler implements HttpHandler {

    private UserAuthenticator authen;
    private String response = "";
    private int code = 200;
    private JSONObject obj = null;

    public RegistrationHandler(UserAuthenticator object) {
        this.authen = object;
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        Headers headers = t.getRequestHeaders();
        String contentType = "";
        
        System.out.println("Entering registration handle");

        try {
            if(t.getRequestMethod().equalsIgnoreCase("POST")){
                if(headers.containsKey("Content-Type")){
                    contentType = headers.get("Content-Type").get(0);
                    if (contentType.equalsIgnoreCase("application/json")){
                        postHandler(t);
                    } else {
                        code = 407;
                        response = "content type is not application/json";
                    }
                } else {
                    code = 411;
                    response = "No content type in request";
                }
            } else {
                code = 401;
                response = "only POST is accepted";
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            code = 500;
            response = "Internal server error";
        }
        System.out.println("writing response");

        byte [] bytes = response.getBytes("UTF-8");
        t.sendResponseHeaders(code, bytes.length);
        OutputStream s = t.getResponseBody(); 
        s.write(bytes);
        s.close();  
    }


    private void postHandler(HttpExchange t) throws IOException, JSONException, SQLException {
        InputStream inputStream = t.getRequestBody();


        String newUser = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));

        inputStream.close();


        if(newUser == null || newUser.length() == 0){
            code = 412;
            response = "no user credentials";
        } else {
            try {
                obj = new JSONObject(newUser);
            } catch (JSONException e) {
                System.out.println("json parse error, faulty user json");
            }

            if (obj.getString("username").length() == 0 || obj.getString("password").length() == 0 || obj.getString("email").length() == 0){
                code = 413;
                response = "user credentials not proper";
            } else {
                System.out.println("registering user" + obj.getString("username") + " " + obj.getString("password"));
                Boolean result = authen.addUser(obj.getString("username"), obj.getString("password"), obj.getString("email"));
                if (result == false){
                    code = 405;
                    response = "user already exists";
                } else {
                    code = 200;
                    response = "User registered";
                }
            }
            
        }
 
    }
    
}
