package dldsimulator;

import java.io.*;
import java.util.*;

public class WriteThread implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String name;

    public WriteThread(NetworkUtil nc, String name) {
        this.nc = nc;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            Scanner input = new Scanner(System.in);

            while (true) {
                //String s=br.readLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        nc.closeConnection();
    }
}
