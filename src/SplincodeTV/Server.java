package SplincodeTV;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(3000);
        System.out.println("Started: " + server);

        try {
            Socket socket = server.accept();

            try {
                System.out.println("Connection accepted: " + socket);

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);

//                while (!socket.isClosed()) {
                while (!socket.isClosed()) {
                    System.out.println(socket.isClosed());

                    Blank bl = (Blank) ois.readObject();
                    System.out.printf("" +
                            "передан объект с полями: " +
                            "%s %s %s \n", bl.x, bl.y, bl.z);

                    oos.writeObject(new Blank(111, 222, 333));
                }
                System.out.println("после цикла - " + socket.isClosed());
            } catch (java.io.EOFException e) {
                System.out.println(e);
                System.out.println("socket closing...");
                socket.close();
            }
        } finally {
            server.close();
        }

    }
}