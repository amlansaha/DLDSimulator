/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author amlansaha
 */
public class DLDSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we)
                {
//                    System.exit(0);
                    int i = JOptionPane.showConfirmDialog(null,"Do you want to save the circuit?");
                        if(i==0)
                            mf.writeToFile();
                    i = JOptionPane.showConfirmDialog(null,"Do you want to exit?");
                    if(i==0)    {
                        System.exit(0);   
                    }
                    if ( i == -1 )  {
                        System.out.println("i == -1");
                    }
                }
            }
        );
    }
}
