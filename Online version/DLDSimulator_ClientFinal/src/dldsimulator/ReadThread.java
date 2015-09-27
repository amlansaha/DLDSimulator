/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import static dldsimulator.DLDSimulator.mf;
import java.util.ArrayList;

/*public class ReadThread implements Runnable
 {
 private Thread thr;
 private NetworkUtil nc;
	

 public ReadThread(NetworkUtil nc) 
 {
 this.nc = nc;
 this.thr = new Thread(this);
 thr.start();
 }
	
 public void run() 
 {
 try
 {
 while(true)
 {
 Object o=nc.read();
 if(o!= null)
 {
 if(o instanceof Circuit)
 {
 Circuit obj=(Circuit)o;
 mf.setCkt(obj);
 //this.ckt.copy(obj);
 //System.out.println(obj.getElement());
 }
 }	
 }
 }catch(Exception e)
 {
 System.out.println (e);                        
 }			
 nc.closeConnection();
		
 }
 }*/
public class ReadThread {
    //private Thread thr;

    private NetworkUtil nc;

    public ReadThread(NetworkUtil nc) {
        this.nc = nc;
        //this.thr = new Thread(this);
        //thr.start();
        Object o = nc.read();
        if (o != null) {
            if (o instanceof Circuit) {
                Circuit obj = (Circuit) o;
                mf.setCkt(obj);
                //this.ckt.copy(obj);
                //System.out.println(obj.getElement());
            }
            if ( o instanceof ArrayList )    {
                FileChooserFrame fc = new FileChooserFrame((ArrayList<String>) o);
                fc.setVisible(true);
                
                String ss;
                while (fc.getFileChooser() != null )    {}
            }
        }

    }
}