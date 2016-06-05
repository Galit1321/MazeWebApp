package objects;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.net.Socket;
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
    /**
     * Constructor.
     */
    public Model() {}
    /**
     * Start - connect to socket and start.
     * @param IP - string
     * @param port - String
     */
    public void Start(String IP, String port) {
        try {
            socket = new Socket(IP, parseInt(port));
            rec = new Receiver(socket);
            t = new Thread(() -> {
                rec.getMsn();
            });
        } catch (IOException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            t.start();
            out1 = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
        }
    }
    /**
     * get rec
     * @return Reciver. 
     */
    public Receiver getRec() {
        return rec;
    }

    /**
     * close the connection and buffer
     * of receive and send msg
     * @throws IOException 
     */
    public void Close() throws IOException {
        out1.close();
        rec.stop();
        socket.close();

    }
    /**
     * send msn
     * @param msg - string 
     */
    public void sendMsn(String msg) {
        out1.println(msg);
    }

    /**
     * get Json
     * @return json
     */
    public ConvertFromJson getJson() {
        return this.rec.getJson();
    }
}
