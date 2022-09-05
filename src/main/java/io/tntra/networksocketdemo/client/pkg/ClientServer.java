package io.tntra.networksocketdemo.client.pkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientServer {

    //initialize socket and input output streams
    private Socket socket=null;
    private DataInputStream input =null;
    private DataOutputStream out=null;



    //constructor having ip address and port as parameter
    public ClientServer(String address,int port) {
    

      try {
        socket=new Socket(address,port);


        System.out.println("connected");

        //input from terminal
        input = new DataInputStream(System.in);


        //sending output to socket
        out= new DataOutputStream(socket.getOutputStream());
      } catch (UnknownHostException u) {
        System.out.println(u);
  
      }catch(IOException i){
        System.out.println(i);
      }


      //string to read msg from input 
      String line ="hi good morning end";

      //keep reading until "end" is entered in string
      while(!line.equals("end")){
        try {
            
            line=input.readUTF();
            
            System.out.println(line);
        } catch (IOException i) {


            System.out.println(i);
        
        }
      }

      //close the connection 
      try {
        input.close();
        out.close();
        socket.close();
      } catch (IOException i) {
        System.out.println(i);

        
      }


    }
    

    public static void main(String args[]) {

        ClientServer client=new ClientServer("127.0.0.1",8080);
        
    }
    
}
