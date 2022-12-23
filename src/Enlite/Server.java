package Enlite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int PORT = 8081;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();

        Scanner in = new Scanner(input.getInputStream());
        while (in.hasNext()) {
            System.out.println(in.nextLine());
        }

        in.close();
        input.close();
        serverSocket.close();

    }


}