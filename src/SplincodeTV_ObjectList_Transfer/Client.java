package SplincodeTV_ObjectList_Transfer;

public class Client {
    public static void main(String[] args) throws Exception {
        Object monitor = new Object();

        SocketClient client = new SocketClient(monitor);

        HelpClientThread helpClientThread = new HelpClientThread(client, monitor);
        helpClientThread.start();
        client.start();
        System.out.println("запустились");
    }
}