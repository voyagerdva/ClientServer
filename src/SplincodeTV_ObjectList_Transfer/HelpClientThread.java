package SplincodeTV_ObjectList_Transfer;

import java.util.UUID;

public class HelpClientThread extends Thread {
    final SocketClient client;
    private final Object monitor;

    public HelpClientThread(SocketClient client, Object monitor) {
        this.client = client;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("run1");

            try {
                Blank blank = new Blank(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
                client.update(blank);
                synchronized (monitor) {
                    monitor.notify();
                }

            } catch (Exception e) {
                System.out.println(e);
            }
            try {
                sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
