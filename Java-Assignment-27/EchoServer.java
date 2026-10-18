import java.io.*;
import java.net.*;
public class EchoServer {
    public static void main(String[] args) {
        int port = 5001;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Echo server started.");
            System.out.println("Waiting for client...");
            try (Socket socket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
                 PrintWriter output = new PrintWriter(
                     socket.getOutputStream(), true)) {
                System.out.println("Client connected.");
                String message;
                while ((message = input.readLine()) != null) {
                    if (message.equalsIgnoreCase("exit")) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                    System.out.println("Received: " + message);
                    output.println(message);
                    System.out.println("Echo sent: " + message);
                }
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
