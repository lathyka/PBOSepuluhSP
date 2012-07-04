
package org.me.multiklien;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PenangananKlient extends Thread
{
    private Socket socketClient;
    private DataInputStream dis;
    private DataOutputStream dos;

    public PenangananKlient(Socket socketClient) 
    {
        this.socketClient = socketClient;
        
    }
    
    @Override
    public void run()
    {
        try {
            dis = new DataInputStream(socketClient.getInputStream());
            dos = new DataOutputStream(socketClient.getOutputStream());
            System.out.println("Sever mendengar pesan dari klien");
            String dataDikirim = dis.readUTF();
            System.out.println("Sever mendapat pesan berisi = "+dataDikirim);
            String pesan = "hello moto";
            System.out.println("Pesan dikirm dari server ke klien");
            dos.writeUTF(pesan);
       //     System.out.println("Server Mati");
        } catch (IOException ex) {
            Logger.getLogger(PenangananKlient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
