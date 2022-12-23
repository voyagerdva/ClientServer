package StackOverFlow1.JavaRush;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int serverPort=8082;
        String adress="127.0.0.1";

        Blank blank = new Blank(0,0,0);
        try
        {
            Socket socket = new Socket(adress, serverPort);
            System.out.println("Устанавливаем соединение");
//            DataInputStream in = new DataInputStream(socket.getInputStream());
//            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

/*          ObjectInputStream
            ObjectOutputStream.
            У них есть методы readObject , writeObject  */

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            out.writeObject(blank);
            out.flush();
//            String line = in.readUTF();
//            System.out.println("Сервер ответил:  " + line);
        }
        catch(Exception er)
        {
            er.printStackTrace();
        }

    }
}