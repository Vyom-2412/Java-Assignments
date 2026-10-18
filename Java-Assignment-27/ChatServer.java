import java.io.*;
import java.net.*;
public class ChatServer {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server started.");
            System.out.println("Waiting for client...");
            try (Socket socket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(
                     socket.getOutputStream(), true);
                 BufferedReader keyboard = new BufferedReader(
                     new InputStreamReader(System.in))) {
                System.out.println("Client connected.");
                String message;
                while (true) {
                    message = input.readLine();
                    if (message == null || message.equalsIgnoreCase("exit")) {
                        System.out.println("Client ended the chat.");
                        break;
                    }
                    System.out.println("Client: " + message);
                    System.out.print("Server reply: ");
                    String reply = keyboard.readLine();
                    output.println(reply);
                    if (reply.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
