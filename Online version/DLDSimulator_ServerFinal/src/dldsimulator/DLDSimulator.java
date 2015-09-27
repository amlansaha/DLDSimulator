/*SERVER*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DLDSimulator {

    private ServerSocket ServSock;
    public static MainFrame mf;

    DLDSimulator() {
        try {

            ServSock = new ServerSocket(44445);
            mf = new MainFrame();
            mf.setVisible(true);
            mf.addWindowListener(
                    new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
//                    System.exit(0);
                    int i = JOptionPane.showConfirmDialog(null, "Do you want to save the circuit?");
                    if (i == 0) {
                        mf.writeToFile();
                    }
                    i = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
                    if (i == 0) {
                        System.exit(0);
                    }
                    if (i == -1) {
                        System.out.println("i == -1");
                    }
                }
            });

            File dir = new File("Circuits");
            if (!dir.exists()) {
                dir.mkdir();
            }
            System.out.println("dir is a directory: " + dir.isDirectory());
            File[] list = dir.listFiles();

        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void active() throws IOException {
        while (true) {
            ServerThread m = new ServerThread(ServSock.accept(), mf.getCkt());
        }
    }

    public static void main(String args[]) throws UnknownHostException, IOException {
        /*mf = new MainFrame();
         mf.setVisible(true);*/

        DLDSimulator objServer = new DLDSimulator();
        objServer.active();
    }
}

class ServerThread implements Runnable {

    private Socket ClientSock;
    private Thread thr;
    private NetworkUtil nc;

    ServerThread(Socket client, Circuit ckt) {
        this.ClientSock = client;
        this.thr = new Thread(this);
        thr.start();
    }

    synchronized public void write() {
        this.nc = new NetworkUtil(ClientSock);
        WriteThread wt = new WriteThread(this.nc, "Server");
    }

    synchronized public void read() {
        this.nc = new NetworkUtil(ClientSock);
        ReadThread rt = new ReadThread(this.nc);
    }

    public void run() {
        /*while(true){
         this.nc=new NetworkUtil(ClientSock);
         WriteThread wt=new WriteThread(this.nc,"Server");
         //wt.write();
         try {
         thr.sleep(2000);
         } 
         catch (InterruptedException ex) {
         Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
         }
         try {
         while(ClientSock.getOutputStream()==null){
                            
         }
         } catch (IOException ex) {
         Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
         }
         ReadThread rt=new ReadThread(nc);
         //rt.read();
         }*/
        //this.write();
        while (true) {

            this.read();
            try {
                thr.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }


            /*this.write();
                
             try {
             thr.sleep(1000);
             } 
             catch (InterruptedException ex) {
             Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
             }
             */

        }

    }
}
