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
import java.util.Map;

/**
 *
 * @author ׳’׳׳™׳×׳•׳ ׳•׳₪׳¨
 */
public class Receiver {

    public Socket socket;
    private BufferedReader in;
    private ConvertFromJson json;
    private Boolean StopRec;

    public Receiver(Socket s) throws IOException {
        this.socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    public String getMsn() {
        while (!StopRec)//while we want the thread to work
        {
            char[] c = new char[4001];
            try {

                in.read(c);
                int i = 0;
                String s = "";
                while (c[i] != 0) {
                    s += c[i];
                    i++;
                }
                this.json.deserlize(s);
                System.out.print(s);
                for (Map.Entry<String, String> entry : this.json.Serlize.entrySet()) {
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                }
            } catch (Exception e) {
            }
            return c.toString();
        }
        return "";
    }

    public void stop() throws IOException {
        in.close();
        this.StopRec = true;
    }
    
    public ConvertFromJson getJson(){
    return this.json;
    }
}
