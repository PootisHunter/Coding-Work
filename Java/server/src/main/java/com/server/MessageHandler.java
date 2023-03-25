package com.server;
import java.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.*;


public class MessageHandler implements HttpHandler {

    private int code = 200;
    private String response;
    private JSONObject obj = null;
    private MessageDatabase db = MessageDatabase.getInstance();
    public MessageHandler() {
    }

    @Override
    public void handle(HttpExchange t) throws IOException {
        try{
            if (t.getRequestMethod().equalsIgnoreCase("POST")){
                handlePostResponse(t);
            } else if (t.getRequestMethod().equalsIgnoreCase("GET")){
                handleGetResponse(t);
            } else {
                handleOtherResponse(t);
            }
        }catch(Exception e){
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            code = 500;
            response = "Internal server error";
        }
        byte [] bytes = response.getBytes("UTF-8");
        t.sendResponseHeaders(code, bytes.length);
        OutputStream s = t.getResponseBody(); 
        s.write(bytes);
        s.close();  
    }
    




    private void handlePostResponse(HttpExchange t) throws IOException, SQLException {
        Headers headers = t.getRequestHeaders();
        String contentType = "";

        if (headers.containsKey("Content-Type")){
            contentType = headers.get("Content-Type").get(0);
            if (contentType.equalsIgnoreCase("application/json")){
                InputStream inputStream = t.getRequestBody();

                String message = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
                inputStream.close();
                if(message == null || message.length() == 0){
                    code = 412;
                    response = "no user credentials";
                } else {
                    try {
                        obj = new JSONObject(message);
                    } catch (JSONException e) {
                        System.out.println("json parse error, faulty user json");
                        code = 400;
                        response = "wrong data type";
                        return;
                    }
                    // handle non double coordinates better
                    if (obj.has("query")){
                        queryHandler(obj);
                    }
                    else if (!(obj.getString("dangertype").equals("Deer") || obj.getString("dangertype").equals("Moose") || obj.getString("dangertype").equals("Reindeer") || obj.getString("dangertype").equals("Other"))){
                        code = 422;
                        response = "dangertype not proper";
                    }
                    else if (obj.getString("nickname").length() == 0){
                        code = 422;
                        response = "user credentials not proper";
                    } else {
                        try {  
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd'T'HH:mm:ss.SSSX");
                            ZonedDateTime zonedDateTime = ZonedDateTime.parse(obj.getString("sent"),formatter);
                            db.setMessage(obj);
                            code = 200;
                            response = "Warning message added";
                        } catch (DateTimeParseException e) {
                            code = 500;
                            response = "parse exception";
                        }
                    }
                        
                }

            }
        } else {
            code = 411;
            response = "No content type in request";
        }
    }

    private void queryHandler(JSONObject obj) throws SQLException {
        JSONArray message;
        if (obj.getString("query").equals("user")){
            message = db.queryUser(obj);
            code = 200;
            response = message.toString();
        } else if (obj.getString("query").equals("time")){
            message = db.queryTime(obj);
            code = 200; 
            response = message.toString();
        } else if (obj.getString("query").equals("location")){
            message = db.queryLocation(obj);
            code = 200;
            response = message.toString();
        } else {
            code = 422;
            response = "query type not supported";
        }
    }

    private void handleGetResponse(HttpExchange t) throws IOException, SQLException {
        // check if empty
        JSONArray responseMessages = db.getMessages();

        response = responseMessages.toString();
    }

    private void handleOtherResponse(HttpExchange t) throws IOException{
        code = 401;
        response = "Not supported";
    }
}
