package JavaRush;

import StackOverFlow1.JavaRush.Blank;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class Client {

//    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
//    private static BufferedReader in; // поток чтения из сокета
//    private static BufferedWriter out; // поток записи в сокет

    private static Socket socket1; //сокет для общения
    private static ObjectInputStream in; // поток чтения в сокет
    private static ObjectOutputStream out; // поток записи из сокета
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как

    public static void main(String[] args) {
        try {
            try {
                StackOverFlow1.JavaRush.Blank blank = new Blank(0, 0, 0);

                System.out.println("старт клиента...");
                socket1 = new Socket("localhost", 4004); // этой строкой мы запрашиваем у сервера доступ на соединение
                reader = new BufferedReader(new InputStreamReader(System.in));

                while (true) {
                    in = new ObjectInputStream(socket1.getInputStream());
                    out = new ObjectOutputStream(socket1.getOutputStream());

//                    System.out.println("Вы что-то хотели сказать? Введите это здесь:");
//                    String word = reader.readLine(); // ждём пока клиент что-нибудь не напишет в консоль
//                    out.write(word + "\n"); // отправляем сообщение на сервер
//                    out.flush();
//                    String serverWord = in.readLine(); // ждём, что скажет сервер
//                    System.out.println(serverWord); // получив - выводим на экран



                    sleep(5000);
                    out.writeObject(blank);
                    out.flush();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally { // в любом случае необходимо закрыть сокет и потоки
                System.out.println("Клиент был закрыт...");
                socket1.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}