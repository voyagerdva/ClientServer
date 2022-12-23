package SplincodeTV_ObjectList_Transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws Exception {
        ArrayList<Blank> blList = null;

        ServerSocket server = new ServerSocket(3001);
        System.out.println("SplincodeTV_ObjectList_Transfer. Started: " + server);

        try {
            Socket socket = server.accept();

            try {
                System.out.println("Connection accepted: " + socket);

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);

                while (!socket.isClosed()) {
//                    blList = (ArrayList<Blank>) ois.readObject();

//                    blList.forEach(blank -> {
//                        System.out.printf("" +
//                                "передан список объектов с полями: %s %s %s %s\n",
//                                blank, blank.x, blank.y, blank.z);
//                    });
                    Blank blank = (Blank) ois.readObject();
                    System.out.println(blank.x);
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