package com.server;

import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpContext;

import com.sun.net.httpserver.HttpsParameters;

import java.security.KeyStore;
import java.util.concurrent.Executors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

import java.io.*;
import java.net.InetSocketAddress;

 


public class Server {

    private Server() {}


    public static void main(String[] args) throws Exception {

        try{
            //create the http server to port 8001 with default logger
            HttpsServer server = HttpsServer.create(new InetSocketAddress(8001),0);
            SSLContext sslContext = serverSSLContext(args);

            server.setHttpsConfigurator (new HttpsConfigurator(sslContext) {
                public void configure (HttpsParameters params) {
                    InetSocketAddress remote = params.getClientAddress();
                    SSLContext c = getSSLContext();
                    SSLParameters sslparams = c.getDefaultSSLParameters();
                    params.setSSLParameters(sslparams);
                }
            });
            //create context that defines path for the resource, in this case a "help"
            HttpContext context = server.createContext("/warning", new MessageHandler());
            UserAuthenticator user = new UserAuthenticator();
            context.setAuthenticator(user);

            server.createContext("/registration", new RegistrationHandler(user));
            // creates a default executor
            server.setExecutor(Executors.newCachedThreadPool()); 
            server.start(); 
        } catch (Exception e) {
        System.out.println(e.getStackTrace());
        e.printStackTrace();
        }
        
    }

    private static SSLContext serverSSLContext(String [] args) throws Exception{

        String password = "Tyyty001";
        String path = "D:/Ohjelmointi/Ohjelmointi 3/group-0106-project/group-0106-project/server/src/main/java/com/server/keystore.jks";

        if(args.length >= 2){
            password = args[1];
            path = args[0];
        }

        char[] passphrase = password.toCharArray();
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream(path), passphrase);

        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, passphrase);

        TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
        tmf.init(ks);

        SSLContext ssl = SSLContext.getInstance("TLS");
        ssl.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);
        return ssl;
    }

    
}
