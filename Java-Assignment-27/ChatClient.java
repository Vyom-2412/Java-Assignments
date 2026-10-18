import java.io.*;
import java.net.*;
public class ChatClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5000;
        try (Socket socket = new Socket(host, port);
             BufferedReader input = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(
                 socket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(
                 new InputStreamReader(System.in))) {
            System.out.println("Connected to chat server.");
            while (true) {
                System.out.print("You: ");
                String message = keyboard.readLine();
                output.println(message);
                if (message == null || message.equalsIgnoreCase("exit")) {
                    break;
                }
                String reply = input.readLine();
                if (reply == null) {
                    break;
                }
                System.out.println("Server: " + reply);
                if (reply.equalsIgnoreCase("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
