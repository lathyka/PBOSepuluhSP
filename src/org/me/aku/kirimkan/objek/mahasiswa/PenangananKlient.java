
package org.me.aku.kirimkan.objek.mahasiswa;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenangananKlient extends Thread
{
    private Socket socketClient;
    private ObjectInputStream dis;
    private ObjectOutputStream dos;

    public PenangananKlient(Socket socketClient) 
    {
        this.socketClient = socketClient;
        
    }
    
    @Override
    public void run()
    {
        try {
            dis = new ObjectInputStream(socketClient.getInputStream());
            dos = new ObjectOutputStream(socketClient.getOutputStream());
            System.out.println("Sever mendengar pesan dari klien");
            Mahasiswa dataDikirim;
            try {
                dataDikirim = (Mahasiswa)dis.readObject();
                 System.out.println(dataDikirim);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PenangananKlient.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
        } catch (IOException ex) {
            Logger.getLogger(PenangananKlient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
