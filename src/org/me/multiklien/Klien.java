
package org.me.multiklien;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Klien extends Thread
{
    Socket mySock;
    DataOutputStream dos;
    DataInputStream dis;
    
    @Override
    public void run()
    {
        try {
            mySock = new Socket("localhost", 2002);
            dos = new DataOutputStream(mySock.getOutputStream());
            dis = new DataInputStream(mySock.getInputStream());
            System.out.println("Klien sudah tersambung tetapi nunggu bentar ya selama 10d");
            try
            {
                Thread.sleep(10000);
            }
            catch(InterruptedException ie)
            {
            }
            dos.writeUTF("ini dikirim");
            System.out.println("Klien telah mengirim data");
            System.out.println("Klien mendengar balik dari server");
            String pesan = dis.readUTF();
            System.out.println("Isi pesan dari server = "+pesan);
            dos.close();
            dis.close();
            mySock.close();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Klien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Klien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    
    public static void main(String[] args) {
        new Klien().start();
    }
}
