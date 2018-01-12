package networkProgramming.onewayConnection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args){
        String ip="localhost";
        int port=9999;
        String data="This is the client data";

        try {
            //initializing the new client socket for the request
            Socket clientSocket=new Socket(ip,port);

            //writing the data into the output stream
            OutputStreamWriter os=new OutputStreamWriter(clientSocket.getOutputStream());
            PrintWriter out=new PrintWriter(os);
            out.println(data);
            //allowing system to accessing all the data in the os
            out.flush();

            Scanner scanner1 = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(scanner1.nextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
