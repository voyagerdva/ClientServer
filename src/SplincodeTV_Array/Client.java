package SplincodeTV_Array;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        int x = 0;
        int y = 0;
        int z = 0;

        Blank[] blankArr = new Blank[5];

        for (int i = 0; i < blankArr.length; i++) {
            blankArr[i] = new Blank(
                    "AAAA" + i,
                    "BBBB" + i,
                    "CCCC" + i);
        }

        Socket socket = new Socket("localhost", 3000);

        try {
            System.out.println("" +
                    "SplincodeTV_Array. socket: "
                    + socket);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(out);
            ObjectInputStream ois = new ObjectInputStream(in);

            oos.writeObject(blankArr);

        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}