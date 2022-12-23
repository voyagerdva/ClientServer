package StackOverFlow1.JavaRush;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static Socket socket1; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
//        Blank blank = new Blank(0,0,0);

        int port=8082;

        try
        {
            ServerSocket ss = new ServerSocket(port);
            while(true) {
                System.out.println("Server start...");
                Socket socket = ss.accept();
                System.out.println("Есть контакт !");
//                DataInputStream in = new DataInputStream(socket.getInputStream());
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                Blank obj = (Blank) in.readObject();

                System.out.printf("Клиент прислал объект: %-2s %-2s %-2s", obj.x, obj.y, obj.z);

//                System.out.println("Отправляем ему в ответ: );

//                out.write??????;
//                out.flush();
            }
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }

    }
}