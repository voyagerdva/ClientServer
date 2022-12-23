package SplincodeTV;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        int z = 0;

        Socket socket = new Socket("localhost", 3000);

        try {
            System.out.println("socket: " + socket);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(out);
            ObjectInputStream ois = new ObjectInputStream(in);

            while (x <= 10) {
                oos.writeObject(new Blank(x, y, z));

                Blank bl = (Blank) ois.readObject();
                System.out.printf("" +
                        "ответ: %-3s %-3s %-3s \n" +
                        "", bl.x, bl.y, bl.z);
                x++;
                y++;
                z++;
            }
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}