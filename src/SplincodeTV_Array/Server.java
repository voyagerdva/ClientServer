package SplincodeTV_Array;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        Blank[] blArr = null;
        ServerSocket server = new ServerSocket(3000);
        System.out.println("SplincodeTV_Array. Started: " + server);

        try {
            Socket socket = server.accept();

            try {
                System.out.println("Connection accepted: " + socket);
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);
                while (!socket.isClosed()) {
                    blArr = (Blank[]) ois.readObject();
                    System.out.println();

                    for (int i = 0; i < blArr.length; i++) {
                        System.out.printf("%s %s %s\n",
                                blArr[i].x, blArr[i].y, blArr[i].z);
                    }
                }
            } catch (EOFException e) {
                System.out.println(e);
                System.out.println("socket closing...");
                socket.close();
            }
        } finally {
            System.out.println("server closing...");
            server.close();
        }
    }
}