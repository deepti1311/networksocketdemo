package server.pkg;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket=null;
    private ServerSocket server=null;
    private DataInputStream in=null;



    public Server(int port) {

        try {
            server=new ServerSocket(port);
            System.out.println("server started");

            System.out.println("waiting for a client ...");

            socket =server.accept();
            System.out.println("Client accepted");


            //taking input from client socket
            in=new DataInputStream(new BufferedInputStream(socket.getInputStream()));


            String line="hi good morning end";


            while(!line.equals("end")){

                try {
                    line=in.readUTF();
                    System.out.println(line);
                } catch (IOException i) {
                    System.out.println(i);
                 
                }
            }

            System.out.println("closing connection ");

            //close connection
            socket.close();
            in.close();

                } 
                
                catch (IOException i) {

                    System.out.println(equals(i));
        
        }


    }

    public static void main(String args[]) {
        Server server=new Server(8080);
        
    }

    
    
}
