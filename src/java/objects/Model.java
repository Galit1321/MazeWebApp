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
   
    public Map<String, User> Users;
    private int Port;
    private String port;
    private PrintWriter out;
   private BufferedReader in;
   
    private static Model singleton = new Model( );
    private Model() {
        try {
            Users=new HashMap<String,User>();
            Socket socket = new Socket("127.1.1.0", 5555);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
   return c.toString();
   }
   
   public Map<String, User>  getUsers(){
      return Users;
   }
}
