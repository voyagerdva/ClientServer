package JavaRush;

import StackOverFlow1.JavaRush.Blank;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Server {

//    private static BufferedReader in; // поток чтения из сокета
//    private static BufferedWriter out; // поток записи в сокет

    private static ServerSocket server;
    private static ObjectInputStream in; // поток чтения в сокет
    private static ObjectOutputStream out; // поток записи из сокета

    public static void main(String[] args) {
        try {
            try {

                server = new ServerSocket(4004); // серверсокет прослушивает порт 4004
                System.out.println("Сервер запущен!"); // хорошо бы серверу объявить о своем запуске

                //сокет для общения
                Socket socket1 = server.accept(); // accept() будет ждать пока кто-нибудь не захочет подключиться

                try { // установив связь и воссоздав сокет для общения с клиентом можно перейти к созданию потоков ввода/вывода. Теперь мы можем принимать сообщения
//                    while (true) {

//                        in = new BufferedReader(new InputStreamReader(socket1.getInputStream())); // принимать
//                        out = new BufferedWriter(new OutputStreamWriter(socket1.getOutputStream())); // и отправлять
                    System.out.println("готовим вх и вых");
                        in = new ObjectInputStream(socket1.getInputStream());
                        out = new ObjectOutputStream(socket1.getOutputStream());

//                        String word = in.readLine(); // ждём пока клиент что-нибудь нам напишет
//                        System.out.println(word);
//
//                        out.write("Ответ сервера: вы написали : " + word + "\n"); // ОТВЕЧАЕМ КЛИЕНТУ
//                        out.flush(); // выталкиваем все из буфера

                    System.out.println("перед приемом объекта");
                    Blank obj = (Blank) in.readObject();
                    System.out.printf("Клиент прислал объект: %-2s %-2s %-2s", obj.x, obj.y, obj.z);
//                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } finally { // в любом случае сокет будет закрыт
                    socket1.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Сервер закрыт!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}