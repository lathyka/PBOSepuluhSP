
package org.me.aku.kirimkan.objek.mahasiswa;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Klien extends Thread
{
    Socket mySock;
    ObjectOutputStream dos;
    ObjectInputStream dis;
    
    @Override
    public void run()
    {
        try {
            mySock = new Socket("localhost", 2002);
            dos = new ObjectOutputStream(mySock.getOutputStream());
            dis = new ObjectInputStream(mySock.getInputStream());
            Mahasiswa a = new Mahasiswa("1111", "Aji");
            dos.writeObject(a);
            System.out.println("Klien telah mengirim data");
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
