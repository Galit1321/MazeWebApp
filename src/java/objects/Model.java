/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class Model {

    public int Port;
    public String port;
    public PrintWriter out;
    BufferedReader in;
    Map<String,User> m;
    private static Model singleton = new Model( );
    private Model() {
        try {
            m=new HashMap<String,User>();
            Socket socket = new Socket("127.1.1.0", 5555);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sendMsn();
            getMsn();
        } catch (Exception e) {
             
        }
    }
     public static Model getInstance( ) {
      return singleton;
   }
     public void sendMsn(){
          out.println("generate maze 1");
     }
   public String getMsn(){
        char[] c=new char[4001];
       try{
     in.read(c);      
    }catch(Exception e) {}
       System.out.print(c);
   return c.toString();
   }
}
