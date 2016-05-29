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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class Model {

    // public Map<String, User> Users;
    private PrintWriter out1;
    private BufferedReader in;
    private ConvertFromJson json;
    private Socket socket;

    public Model()  {

        try {
            socket = new Socket("127.1.1.0", 5555);
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Start() {
        try{
        out1 = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }catch(Exception e){
    }
    }

    public void Close() throws IOException {
        out1.close();
        in.close();
    }

    public void sendMsn(String msg) {
        out1.println(msg);
    }

    public String getMsn() {
        char[] c = new char[4001];
        try {
            in.read(c);
            int i = 0;
            String s = "";
            while (c[i] != 0) {
                s += c[i];
                i++;
            }
            this.json = new ConvertFromJson(s);
            System.out.print(s);
            for (Map.Entry<String, String> entry : this.json.Serlize.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
            }

        } catch (Exception e) {
        }
        return c.toString();
    }

    /**
     * public Map<String, User> getUsers() { return Users; }
     */
    public ConvertFromJson getJson() {
        return this.json;
    }
}
