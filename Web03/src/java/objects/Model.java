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

    private PrintWriter out1;
    private Socket socket;

    private static Thread t;
    private Receiver rec;

    public Model() {

        try {
            socket = new Socket("127.1.1.0", 5555);
            //   json=new ConvertFromJson();
            rec = new Receiver(socket);
            t = new Thread(() -> {
                rec.getMsn();
            });
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Start() {
        try {
            t.start();
            out1 = new PrintWriter(socket.getOutputStream(), true);
            //  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
        }
    }

    public Receiver getRec() {
        return rec;
    }

    /*
close the connection and buffer
of receive and send msg
     */
    public void Close() throws IOException {
        out1.close();
        socket.close();
        rec.stop();
    }

    public void sendMsn(String msg) {
        out1.println(msg);
    }


    public ConvertFromJson getJson() {
        return this.rec.getJson();
    }
}
