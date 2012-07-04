
package org.me.socket.single;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Klient 
{
    public static void main(String[] args) 
    {
        try {
            Socket mySock = new Socket("localhost", 2000);
            DataOutputStream myOutput = new DataOutputStream(mySock.getOutputStream());
            myOutput.writeUTF("ini pesan aji");
            System.out.println("Behasil dikirim");
            myOutput.close();
            mySock.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
