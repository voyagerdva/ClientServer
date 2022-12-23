package SplincodeTV_HashMap_Transfer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        int z = 0;

        HashMap<Integer, Blank> blankMap = new HashMap<>();
        blankMap.put(1000, new Blank("A0", "B0", "C0"));
        blankMap.put(1001, new Blank("A1", "B1", "C1"));
        blankMap.put(1002, new Blank("A2", "B2", "C2"));
        blankMap.put(1003, new Blank("A3", "B3", "C3"));
        blankMap.put(1004, new Blank("A4", "B4", "C4"));

        Socket socket = new Socket("localhost", 3000);

        try {
            System.out.println("" +
                    "SplincodeTV_HashMap_Transfer. socket: "
                    + socket);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(out);
            ObjectInputStream ois = new ObjectInputStream(in);
            oos.writeObject(blankMap);
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}