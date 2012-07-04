
package org.me.socket.kalopakaithread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Klient extends Thread
{
    Socket mySock;
    
    @Override
    public void run()
    {
        try {
            mySock = new Socket("localhost", 2001);
            System.out.println("Saya sudah tersambung....");
            ObjectOutputStream myOutput = new ObjectOutputStream(mySock.getOutputStream());
            String kiriman = JOptionPane.showInputDialog(null,"apa pesan anda ke server");
            myOutput.writeObject(kiriman);
            System.out.println("Saya sudah kirim data");
            myOutput.close();
            mySock.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Klient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public static void main(String[] args) 
    {
        new Klient().start();
    }
}
