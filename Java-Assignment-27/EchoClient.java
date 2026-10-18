import java.io.*;
import java.net.*;
public class EchoClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;
        try (Socket socket = new Socket(host, port);
             BufferedReader input = new BufferedReader(
                 new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(
                 socket.getOutputStream(), true);
             BufferedReader keyboard = new BufferedReader(
                 new InputStreamReader(System.in))) {
            System.out.println("Connected to echo server.");
            System.out.println("Type 'exit' to stop.");
            while (true) {
                System.out.print("Enter message: ");
                String message = keyboard.readLine();
                if (message == null || message.equalsIgnoreCase("exit")) {
                    output.println("exit");
                    break;
                }
                output.println(message);
                String response = input.readLine();
                if (response == null) {
                    System.out.println("Server disconnected.");
                    break;
                }
                System.out.println("Echo from server: " + response);
            }
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}
