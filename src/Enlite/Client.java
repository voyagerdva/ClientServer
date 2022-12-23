package Enlite;

import java.io.*;
import java.net.Socket;

public class Client {

    private static String HOST = "localhost";
    private static int PORT = 8081;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(HOST, PORT);

        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("Hello");
        out.println("World");
        out.println("How are you?");


        out.close();
        socket.close();
    }

}