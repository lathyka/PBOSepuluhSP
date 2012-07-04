
package org.me.multiklien;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Myserver extends Thread
{
    public static int nomorKlien = 0;
    ServerSocket myServer;
    
    @Override
    public void run()
    {
        try {
            myServer = new ServerSocket(2002);
            System.out.println("Server Running..........");
            
            while(true)
            {
                System.out.println("Server menunggu adanya klien............................");
                 Socket socketClient = myServer.accept();
                 System.out.println("Sambungan dari klien dengan nomor "+nomorKlien++);
                 PenangananKlient penKli = new PenangananKlient(socketClient);
                 penKli.start();
            }
           
        } catch (IOException ex) {
            Logger.getLogger(Myserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) 
    {
        new Myserver().start();
    }
}
