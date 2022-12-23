package SplincodeTV_HashMap_Transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Blank>  blankMap;

        ServerSocket server = new ServerSocket(3000);
        System.out.println("SplincodeTV_ObjectList_Transfer. Started: " + server);

        try {
            Socket socket = server.accept();

            try {
                System.out.println("Connection accepted: " + socket);

                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(out);
                ObjectInputStream ois = new ObjectInputStream(in);

                while (true) {
                    blankMap = (HashMap<Integer, Blank> ) ois.readObject();

                    System.out.println(blankMap.keySet());
                    System.out.println(blankMap.values());
                    blankMap.values().forEach(b -> {
                        System.out.printf("%s %s %s\n", b.x, b.y, b.z);
                    });
                    System.out.println();

                    for (Map.Entry entry: blankMap.entrySet()) {
                        System.out.println(entry);
                        System.out.println(entry.toString());
                        System.out.printf("%s %s\n", entry.getKey(), entry.getValue());
                        System.out.println();
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