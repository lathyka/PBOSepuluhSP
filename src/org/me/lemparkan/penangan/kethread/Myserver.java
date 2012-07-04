
package org.me.lemparkan.penangan.kethread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Myserver extends Thread
{
    ServerSocket myServer;
    
    @Override
    public void run()
    {
        try {
            myServer = new ServerSocket(2002);
            System.out.println("Server Running..........");
            Socket socketClient = myServer.accept();
            System.out.println("Sambungan dari klien");
            PenangananKlient penKli = new PenangananKlient(socketClient);
            penKli.start();
        } catch (IOException ex) {
            Logger.getLogger(Myserver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) 
    {
        new Myserver().start();
    }
}
