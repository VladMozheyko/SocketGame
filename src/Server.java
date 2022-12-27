import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8056);
        int a = 1;
        int count = 0;

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Подключение: " + count++);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


          //  int b = Integer.parseInt(reader.readLine());


            while (true) {

               int b = Integer.parseInt(reader.readLine());
                if (a == b) {
                    writer.write("Прямое попадание");
                    writer.newLine();
                    writer.flush();

                } else {
                    writer.write("Попробуйте еще раз");
                    writer.newLine();
                    writer.flush();
                }


                if (a == b) {
                    writer.close();
                    reader.close();
                    socket.close();
                    break;
                }

            }
        }


    }
}
