package com.borlot.gubeeapp;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        //System.out.println( "Hello World!" );
        int serverPort = 8085;
        HttpServer server = HttpServer.create(new InetSocketAddress(serverPort), 0);

        HttpContext context = server.createContext("/hello", exchange -> {
            if("GET".equals(exchange.getRequestMethod())){
                String hello = "Hello world!";
                exchange.sendResponseHeaders(200, hello.getBytes().length);
                OutputStream output = exchange.getResponseBody();
                output.write(hello.getBytes());
                output.flush();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
            exchange.close();
        });
        server.setExecutor(null);
        server.start();
    }
}
