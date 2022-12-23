package SplincodeTV_ObjectList_Transfer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class SocketClient extends Thread {
    private final Object monitor;
    private Blank blank;

    public SocketClient(Object monitor) {
        this.monitor = monitor;
        addKeyListner();
    }

    public void update(Blank blank) {
        this.blank = blank;
    }

    @Override
    public void run() {
        int x = 0;
        int y = 0;
        int z = 0;

        java.util.List<Blank> blankList = new ArrayList<>();
        blankList.add(new Blank("A0", "B0", "C0"));
        blankList.add(new Blank("A1", "B1", "C1"));
        blankList.add(new Blank("A2", "B2", "C2"));
        blankList.add(new Blank("A3", "B3", "C3"));
        blankList.add(new Blank("A4", "B4", "C4"));

        Socket socket = null;
        try {
            socket = new Socket("localhost", 3001);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("" +
                    "SplincodeTV_ObjectList_Transfer. socket: "
                    + socket);

            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(out);
            ObjectInputStream ois = new ObjectInputStream(in);

            while (true) {
                synchronized (monitor) {
                    monitor.wait();
                }

                System.out.println("послали сообщение");
                oos.writeObject(blank);
//                try {
//                    sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("closing...");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
