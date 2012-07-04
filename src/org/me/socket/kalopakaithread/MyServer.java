
package org.me.socket.kalopakaithread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer extends Thread
{
    ServerSocket myServer;
    @Override
    public void run()
    {
        try {
            System.out.println("Server running .......");
            myServer = new ServerSocket(2001);
            System.out.println("server menerima sambungan dari klien.....");
            Socket mySockKlien = myServer.accept();
            ObjectInputStream myInput = new ObjectInputStream(mySockKlien.getInputStream());
            try {
                Object data  = myInput.readObject();
                
                if(data instanceof String)
                {
                    System.out.println("Dikirim data = "+ data.toString());
                }
              //  myInput.close();
                //mySockKlien.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
        }
    
    public static void main(String[] args) {
        new MyServer().start();
    }
}
