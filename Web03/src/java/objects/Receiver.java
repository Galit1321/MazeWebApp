
package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Map;

/**
 * Receiver
 */
public class Receiver {

    public Socket socket;
    private BufferedReader in;
    private ConvertFromJson json;
    private Boolean StopRec;
    private Boolean datarec;
    private String Answ;
    /**
     * Constructor.
     * @param s - socket
     * @throws IOException 
     */
    public Receiver(Socket s) throws IOException {
        this.socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        datarec = false;
        this.json = new ConvertFromJson();
        StopRec = false;
    }
    /**
     * get data Rec
     * @return boolean
     */
    public Boolean getDataRec() {
        return this.datarec;
    }
    /**
     * GetMsn - get message.
     */
    public void getMsn() {
        while (!StopRec)//while we want the thread to work
        {
            datarec = false;
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
                this.Answ = s;
             
            } catch (Exception e) {
                ///to change
                StopRec=false;
            }
            datarec = true;
          
        }

    }
    /**
     * get anw
     * @return answer. 
     */
    public String getAnw() {
        return this.Answ;
    }
    /**
     * stop
     * @throws IOException 
     */
    public void stop() throws IOException {
        in.close();
        this.StopRec = true;
    }
    /**
     * get json.
     * @return json
     */
    public ConvertFromJson getJson() {
        return this.json;
    }
}
