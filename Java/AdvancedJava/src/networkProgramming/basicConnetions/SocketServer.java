package networkProgramming.onewayConnection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args){
        try {
            //initializing the server socket
            System.out.println("testing");
            ServerSocket ss=new ServerSocket(9999);

            //when server socket accept the new request then creating a new corresponding socket
            Socket newSocket=ss.accept();
            System.out.println("Request accepted");

            //get the data using socket.getInputStream
            Scanner scanner=new Scanner(new InputStreamReader(newSocket.getInputStream()));
            System.out.println(scanner.nextLine());

            //output from the server
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(newSocket.getOutputStream());
            PrintWriter printWriter=new PrintWriter(outputStreamWriter);
            printWriter.println("data sending from server to client");
            printWriter.flush();

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
