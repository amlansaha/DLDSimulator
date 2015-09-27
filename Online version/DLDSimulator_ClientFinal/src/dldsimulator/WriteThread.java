/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dldsimulator;

import static dldsimulator.DLDSimulator.mf;
import static dldsimulator.DLDSimulator.requestType;
import javax.swing.JOptionPane;
/*public class WriteThread implements Runnable
{
	
	private Thread thr;
	private NetworkUtil nc;
	String name;

	public WriteThread(NetworkUtil nc,String name) 
	{
		this.nc = nc;
		this.name=name;
		this.thr = new Thread(this);
		thr.start();
	}
	
	public void run() 
	{
		try
		{
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			//Scanner input=new Scanner(System.in);
						
			while(true)
			{
				//String s=br.readLine();
				//String s=input.nextLine();
				//Data d=new Data(name+":"+s);				
				nc.write(mf.getCkt());																
			}
		}catch(Exception e)
		{
			System.out.println (e);
		}			
		nc.closeConnection();
	}
}*/


public class WriteThread{
    //private Thread thr;
    private NetworkUtil nc;
    String name;

    public WriteThread(NetworkUtil nc1,String name) 
    {
            this.nc = nc1;
            this.name=name;
            //this.thr = new Thread(this);
            //thr.start();
            switch (requestType)    {
                    case "upload":
                        String obj;
                        obj = JOptionPane.showInputDialog("Enter the upload file name.");
                        if ( !obj.endsWith(".ser")) obj = obj+".ser";
//                        Circuit ckt2 = DLDSimulator.mf.getCkt();
//                        ckt2.name = obj;
                        nc.write(obj);
                        requestType = "";
                        break;
                    case "download":
//                        System.out.println("Request Type: "+DLDSimulator.requestType);
//                        nc.write(new Integer(10));
//                        requestType = "";
//                        System.out.println("Sending Integer");
                        break;
                    default:
                        System.out.println("Request Type: "+DLDSimulator.requestType);
                    	nc.write(mf.getCkt());
                }
    }
}

