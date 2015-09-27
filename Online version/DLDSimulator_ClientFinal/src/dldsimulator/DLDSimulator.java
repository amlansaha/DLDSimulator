/*CLIENT*/

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DLDSimulator {

    public static MainFrame mf;
    public static int flag = 0;
    public static String requestType;

    DLDSimulator() {
        try {
            requestType = "";
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

            ServerThread m = new ServerThread();
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public static void main(String args[]) throws UnknownHostException, IOException {

        DLDSimulator objServer = new DLDSimulator();
    }
}

class ServerThread implements Runnable {

    private String serverAddress = "localhost";
    private int serverPort = 44445;
    private Thread thr;
    private NetworkUtil nc;

    ServerThread() {

        this.thr = new Thread(this);
        thr.start();
    }

    synchronized public void read() {
        this.nc = new NetworkUtil(serverAddress, serverPort);
        ReadThread rt = new ReadThread(nc);
    }

    synchronized public void write() {
        this.nc = new NetworkUtil(serverAddress, serverPort);
        WriteThread wt = new WriteThread(nc, "Client");
    }

    public void run() {

        /*while(true){
         NetworkUtil nc=new NetworkUtil(serverAddress,serverPort);
         ReadThread rt=new ReadThread(nc);
                    
         try {
         thr.sleep(2000);
         } catch (InterruptedException ex) {
         Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
         }
         WriteThread wt=new WriteThread(nc,"Client");
                    
         }*/

        while (true) {
            /*
             } catch (InterruptedException ex) {
             Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
             }*/

            switch (DLDSimulator.requestType) {
                case "download":
                    this.read();
                    DLDSimulator.requestType = "";
                    break;
                default:
                    this.write();
                    try {
                        thr.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }

        }
    }
}