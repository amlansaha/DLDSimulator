/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import static dldsimulator.DLDSimulator.mf;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

//		                    try {
//				                Circuit ckt2 = (Circuit) obj;
////				                if ( ckt2.name == "" || ckt2.name == ".ser" )	
//				                String path = "Circuits"+File.separator+ckt2.name;
//				                File file = new File(path);
//				                FileOutputStream fos = new FileOutputStream(file);
//				                ObjectOutputStream oos = new ObjectOutputStream(fos);
//				                oos.writeObject(ckt2);
//				                oos.flush();
//				                oos.close();
//				            } catch (IOException e) {
//				                System.out.println("Exception during serialization: " + e);
//		//                        System.exit(0);
//				            }

            } else if (o instanceof String) {
                try {
                    System.out.println("INSTANCE OF STRING..................");
                    File file = new File("Circuits/"+(String) o); //FILENAME & DIRECTORY TO BE SET
                    System.out.println("FILE: " + file.exists());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(DLDSimulator.mf.getCkt());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (o instanceof Integer) {
                File dir = new File("Circuits");
                String[] list = new String[0];
                if (dir.exists() && dir.isDirectory()) {
                    list = dir.list();
                }
                ArrayList<String> fileList = new ArrayList<>();
                for (int i = 0; i < list.length; i++) {
                    if (list[i].endsWith(".ser")) {
                        fileList.add(list[i]);
                    }
                }
                
                System.out.println("Instanceof Integer..........");
                nc.write(fileList);

            }
        }


    }

    ReadThread(NetworkUtil nc, String server) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}