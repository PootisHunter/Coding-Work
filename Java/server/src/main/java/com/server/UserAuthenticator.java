package com.server;

import java.sql.SQLException;


import org.json.JSONException;
import org.json.JSONObject;

import com.sun.net.httpserver.BasicAuthenticator;

public class UserAuthenticator extends BasicAuthenticator{

    private MessageDatabase db = null;
    
    public UserAuthenticator() {
        super("warning");
        db = MessageDatabase.getInstance();
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        System.out.println("checking user:"+ username + " " + password + "\n");
        boolean isValidUser;
        try{
            isValidUser = db.authenticateUser(username,password);
        } catch (SQLException e){
            System.out.println(e.getStackTrace());
            e.printStackTrace();
            return false;
        }
        return isValidUser;
    }

    public boolean addUser(String userName, String password, String email) throws JSONException, SQLException {
        boolean result = db.setUser(new JSONObject().put("username", userName).put("password", password).put("email", email));
        if (!result){
            System.out.println("cannot register user");
            return false;
        }
        System.out.println(userName + "registered");

        return true;
    }
}
