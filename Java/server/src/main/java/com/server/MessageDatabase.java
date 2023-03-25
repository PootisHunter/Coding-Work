package com.server;

import java.io.File;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.security.SecureRandom;
import org.apache.commons.codec.digest.Crypt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageDatabase {

    private Connection dbConnection = null;
    private static MessageDatabase dbInstance = null;
    private SecureRandom secureRandom = new SecureRandom();

    public static synchronized MessageDatabase getInstance() {
        if (null == dbInstance) {
            dbInstance = new MessageDatabase();
        }
        return dbInstance;
    }

    private MessageDatabase() {
        try {
            open();
        } catch (SQLException e) {
            System.out.println("Log - SQLexception");
            System.out.println(e.getStackTrace());
        }
    }

    public void open() throws SQLException {
        String dbName = "database.db";
        File file = new File(dbName);
        Boolean dataExists = file.exists();
        String database = "jdbc:sqlite:" + dbName;
        dbConnection = DriverManager.getConnection(database);
        if (!dataExists) {
            initDatabase();
        }
    }

    private boolean initDatabase() throws SQLException {
        if (null != dbConnection) {
            String createBasicDB = "CREATE TABLE IF NOT EXISTS messages (" +
                    "nickname TEXT NOT NULL," +
                    "longitude REAL NOT NULL," +
                    "latitude REAL NOT NULL," +
                    "sent INT NOT NULL," +
                    "dangertype varchar(50) NOT NULL," +
                    "areacode TEXT NOT NULL," +
                    "phonenumber TEXT NOT NULL)";
            Statement createStatement = dbConnection.createStatement();
            createStatement.executeUpdate(createBasicDB);
            String createUserDB = "CREATE TABLE IF NOT EXISTS users (" +
                    "username TEXT NOT NULL, " +
                    "password TEXT NOT NULL, " +
                    "salt TEXT NOT NULL," +
                    "email TEXT NOT NULL, primary key (username))";
            createStatement.executeUpdate(createUserDB);
            createStatement.close();
            System.out.println("Database creation successful");
            return true;
        } else {
            System.out.println("Database creation failed");
            return false;
        }
    }

    public void closeDB() throws SQLException {
        if (null != dbConnection) {
            dbConnection.close();
            System.out.println("closing db connection");
            dbConnection = null;
        }
    }

    public boolean authenticateUser(String userName, String password) throws SQLException {
        Statement queryStatement = null;
        ResultSet rs;

        String getMessagesString = "select username, password from users where username = '" + userName + "'";
        System.out.println(userName);

        queryStatement = dbConnection.createStatement();
        rs = queryStatement.executeQuery(getMessagesString);

        if (rs.next() == false) {
            System.out.println("cannot find user");
            return false;
        } else {
            String pass = rs.getString("password");
            String hashedpassword = Crypt.crypt(password, pass);
            if (pass.equals(hashedpassword)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Sets the given JSONObject as a new user in the database.
     * <p>
     * The user parameter must contain the following fields:
     * <p>
     * - "username" (String): the username of the user to be created.
     * <p>
     * - "password" (String): the plaintext password of the user to be created.
     * <p>
     * - "email" (String): the email address of the user to be created.
     * <p>
     * 
     * @param user the JSONObject to be set as a new user in the database.
     *             <p>
     * 
     * @return true if the user was successfully created in the database, false if a
     *         user with the same username already exists.
     *         <p>
     *
     * @throws SQLException if a database access error occurs or this method is
     *                      called on a closed connection.
     */
    public boolean setUser(JSONObject user) throws SQLException {

        if (checkIfUserExists(user.getString("username"))) {
            return false;
        }
        byte bytes[] = new byte[13];
        secureRandom.nextBytes(bytes);

        String saltBytes = new String(Base64.getEncoder().encode(bytes));
        String salt = "$6$" + saltBytes;

        String hashedPassword = Crypt.crypt(user.getString("password"), salt);
        String setUserString = "insert into users " + "VALUES('" + user.getString("username") +
                "','" + hashedPassword +
                "','" + salt +
                "','" + user.getString("email") + "')";
        Statement createStatement;
        createStatement = dbConnection.createStatement();
        createStatement.executeUpdate(setUserString);
        createStatement.close();
        return true;
    }

    /**
     * Checks whether a user with the given username exists in the database.
     * 
     * @param givenUsername the username to be checked for existence in the
     *                      database.
     * @return true if a user with the given username exists in the database, false
     *         otherwise.
     * @throws SQLException if a database access error occurs or this method is
     *                      called on a closed connection.
     */
    public boolean checkIfUserExists(String givenUsername) throws SQLException {
        Statement queryStatement = null;
        ResultSet rs;

        String checkUser = "select username from users where username = '" + givenUsername + "'";
        System.out.println("checking user");

        queryStatement = dbConnection.createStatement();
        rs = queryStatement.executeQuery(checkUser);

        if (rs.next()) {
            System.out.println("user exists");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the given JSONObject as a new message in the database.
     * 
     * @param message the JSONObject to be set as a new message in the database. It
     *                must contain the following fields:
     * 
     *                <p>
     *                - "nickname" (String): the nickname of the user who sent the
     *                message.
     *
     *                <p>
     *                - "longitude" (Double): the longitude of the location
     *                associated with the message.
     * 
     *                <p>
     *                - "latitude" (Double): the latitude of the location associated
     *                with the message.
     * 
     *                <p>
     *                - "sent" (String): the date and time when the message was
     *                sent, in the format "yyyy-MM-dd HH:mm:ss".
     * 
     *                <p>
     *                - "dangertype" (String): the type of danger reported in the
     *                message.
     * 
     *                <p>
     *                - "areacode" (String, optional): the area code associated with
     *                the phone number of the user who sent the message.
     * 
     *                <p>
     *                - "phonenumber" (String, optional): the phone number of the
     *                user who sent the message.
     * @throws SQLException if a database access error occurs or this method is
     *                      called on a closed connection.
     */
    public void setMessage(JSONObject message) throws SQLException {
        String areacode = null;
        String phonenumber = null;
        if (message.has("areacode") && message.has("phonenumber")) {
            areacode = message.getString("areacode");
            phonenumber = message.getString("phonenumber");
        }
        String setMessageString = "insert into messages " +
                "VALUES('" + message.getString("nickname") +
                "','" + message.getDouble("longitude") +
                "','" + message.getDouble("latitude") +
                "','" + message.getString("sent") +
                "','" + message.getString("dangertype") +
                "','" + areacode +
                "','" + phonenumber + "')";
        Statement createStatement;
        createStatement = dbConnection.createStatement();
        createStatement.executeUpdate(setMessageString);
        createStatement.close();
    }

    /**
     * Returns a JSONArray object containing all the messages stored in the
     * database.
     * 
     * @return a JSONArray object containing all the messages stored in the
     *         database.
     * @throws SQLException if a database access error occurs or this method is
     *                      called on a closed connection.
     */
    public JSONArray getMessages() throws SQLException {

        Statement queryStatement = null;

        String getMessagesString = "select nickname, longitude, latitude, sent, dangertype, areacode, phonenumber from messages";

        queryStatement = dbConnection.createStatement();
        ResultSet rs = queryStatement.executeQuery(getMessagesString);

        JSONArray jArray = new JSONArray();

        while (rs.next()) {
            JSONObject obj = new JSONObject();

            obj.put("nickname", rs.getString("nickname"));
            obj.put("longitude", rs.getDouble("longitude"));
            obj.put("latitude", rs.getDouble("latitude"));
            obj.put("sent", rs.getString("sent"));
            obj.put("dangertype", rs.getString("dangertype"));
            // checking if areacode exists
            String areacode = rs.getString("areacode");
            if (!areacode.equals("null") && !areacode.isEmpty()) {
                obj.put("areacode", areacode);
            }
            // checking if phonenumber exists
            String phonenumber = rs.getString("phonenumber");
            if (!phonenumber.equals("null") && !phonenumber.isEmpty()) {
                obj.put("phonenumber", phonenumber);
            }
            jArray.put(obj);
        }
        return jArray;
    }

    public JSONArray queryUser(JSONObject obj) throws JSONException, SQLException {

        String username = obj.getString("nickname");
        PreparedStatement stm = dbConnection.prepareStatement("SELECT nickname, longitude, latitude, sent, dangertype, areacode, phonenumber FROM messages WHERE nickname=?");
        
        stm.setString(1, username);
        ResultSet rs = stm.executeQuery();

        JSONArray jArray = new JSONArray();
        while (rs.next()) {
            JSONObject obj2 = new JSONObject();

            obj2.put("nickname", rs.getString("nickname"));
            obj2.put("longitude", rs.getDouble("longitude"));
            obj2.put("latitude", rs.getDouble("latitude"));
            obj2.put("sent", rs.getString("sent"));
            obj2.put("dangertype", rs.getString("dangertype"));
            // checking if areacode exists
            String areacode = rs.getString("areacode");
            if (!areacode.equals("null") && !areacode.isEmpty()) {
                obj2.put("areacode", areacode);
            }
            // checking if phonenumber exists
            String phonenumber = rs.getString("phonenumber");
            if (!phonenumber.equals("null") && !phonenumber.isEmpty()) {
                obj2.put("phonenumber", phonenumber);
            }
            jArray.put(obj2);
        }

        return jArray;
    }

    public JSONArray queryTime(JSONObject obj) throws SQLException {
        
        String timestart = obj.getString("timestart");
        String timeend = obj.getString("timeend");
        PreparedStatement stm = dbConnection.prepareStatement("SELECT * FROM messages WHERE sent >= CAST(? as DATETIME) AND sent <= CAST(? as DATETIME)");
        stm.setString(1, timestart);
        stm.setString(2, timeend);
        
        ResultSet rs = stm.executeQuery();
        JSONArray jArray = new JSONArray();
        while (rs.next()) {
            JSONObject obj2 = new JSONObject();

            obj2.put("nickname", rs.getString("nickname"));
            obj2.put("longitude", rs.getDouble("longitude"));
            obj2.put("latitude", rs.getDouble("latitude"));
            obj2.put("sent", rs.getString("sent"));
            obj2.put("dangertype", rs.getString("dangertype"));
            // checking if areacode exists
            String areacode = rs.getString("areacode");
            if (!areacode.equals("null") && !areacode.isEmpty()) {
                obj2.put("areacode", areacode);
            }
            // checking if phonenumber exists
            String phonenumber = rs.getString("phonenumber");
            if (!phonenumber.equals("null") && !phonenumber.isEmpty()) {
                obj2.put("phonenumber", phonenumber);
            }
            jArray.put(obj2);
        }

        return jArray;
    }

    public JSONArray queryLocation(JSONObject obj) throws SQLException {
        String uplongitude = Double.toString(obj.getDouble("uplongitude"));
        String downlongitude = Double.toString(obj.getDouble("downlongitude"));
        String uplatitude = Double.toString(obj.getDouble("uplatitude"));
        String downlatitude = Double.toString(obj.getDouble("downlatitude"));
        PreparedStatement stm = dbConnection.prepareStatement("SELECT * FROM messages WHERE (latitude BETWEEN ? AND ?) AND (longitude BETWEEN ? AND ?)");
        stm.setString(1, downlatitude);
        stm.setString(2, uplatitude);
        stm.setString(3, uplongitude);
        stm.setString(4, downlongitude);
        
        ResultSet rs = stm.executeQuery();
        JSONArray jArray = new JSONArray();
        while (rs.next()) {
            JSONObject obj2 = new JSONObject();

            obj2.put("nickname", rs.getString("nickname"));
            obj2.put("longitude", rs.getDouble("longitude"));
            obj2.put("latitude", rs.getDouble("latitude"));
            obj2.put("sent", rs.getString("sent"));
            obj2.put("dangertype", rs.getString("dangertype"));
            // checking if areacode exists
            String areacode = rs.getString("areacode");
            if (!areacode.equals("null") && !areacode.isEmpty()) {
                obj2.put("areacode", areacode);
            }
            // checking if phonenumber exists
            String phonenumber = rs.getString("phonenumber");
            if (!phonenumber.equals("null") && !phonenumber.isEmpty()) {
                obj2.put("phonenumber", phonenumber);
            }
            jArray.put(obj2);
        }

        return jArray;
    }
 
}
