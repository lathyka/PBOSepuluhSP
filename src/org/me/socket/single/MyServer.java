
package org.me.socket.single;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyServer 
{
    public static void main(String[] args) 
    {
       
        try {
            ServerSocket myServer = new ServerSocket(2000);
             System.out.println("Server running........");
            Socket mySocketDariClient = myServer.accept();
            System.out.println("Sever menerima sambungan dari klien");
            DataInputStream myInput = new DataInputStream(mySocketDariClient.getInputStream());
            String dataMasuk = myInput.readUTF();
            System.out.println("Dikirim dari klient = "+dataMasuk);
            myInput.close();
            mySocketDariClient.close();
        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
