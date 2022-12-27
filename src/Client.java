import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8056);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        System.out.println("Клиент работает");
        Scanner scanner = new Scanner(System.in);
        while (!reader.equals("Прямое попадание")) {
        System.out.println("Введите число: ");
        int a = scanner.nextInt();
        writer.write(String.valueOf(a));
        writer.newLine();
        writer.flush();

        System.out.println(reader.readLine());
    }
    }
}
