package client;

import server.MainServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MainClient {
    public static void main(String[] args) throws IOException {

        Socket client = new Socket("127.0.0.1", MainServer.SERVER_PORT);

        InputStream from = client.getInputStream();
        OutputStream to = client.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(from));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(to));

        Scanner scanner = new Scanner(System.in);

        String message;
        while(!(message = scanner.nextLine()).isEmpty()) {
            writer.write(message);
            writer.newLine();
            writer.flush();

            System.out.println("Server echo: " + reader.readLine());
        }
    }
}
