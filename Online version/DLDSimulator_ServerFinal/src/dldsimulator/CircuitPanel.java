/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import javax.swing.JPanel;
import devices.*;
    
public class CircuitPanel extends JPanel {
    
    public static int distance;
    public Circuit ckt;
    
    public CircuitPanel() {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
    }
    
    public CircuitPanel(Circuit ckt) {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
        this.ckt = ckt; 
    }
    
    boolean paintPoint (Graphics g)    {    //returns true if successful, false otherwise
        Color c = g.getColor();
        if ( ckt.pointFlag )    g.setColor(Color.RED);
        else    g.setColor(Color.BLUE);
        
        try {
            Coordinate cd = new Coordinate(MainFrame.mouseMove);
            g.fillRect(cd.x-3, cd.y-3, 6, 6);
            g.setColor(c);
            return true;
        }catch(Exception e) {            
            e.printStackTrace();
            g.setColor(c);
            return false;
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.DARK_GRAY);
        int height = this.getPreferredSize().height;
        int width = this.getPreferredSize().width;
        
        for ( int i = 0; i < height; i+= 10 )    {
            for ( int j = 0; j < width; j+= 10 ) {
                g.drawLine(j, i, j, i);
            }
        }
        
        g.setColor ( Color.BLACK);
        ckt.drawCircuit(g);
        
        if ( MainFrame.mode == ModeEnum.drawing )   {
            if ( MainFrame.currentDev == DeviceEnum.wire )  {
                paintPoint(g);
            }
            else    {
                g.setColor(Color.blue);
                paintTemp(g);
            }
        }
        
//        int i = 
    }
    
    private boolean paintTemp(Graphics g)  {   //returns true if successful, false otherwise
        
        g.setColor(Color.blue);
        try {
            if ( MainFrame.mode == ModeEnum.drawing )
                if ( ckt != null )  {
                    Device temp = ckt.getTemp();
                    
                    if ( temp != null ) {
                        temp.draw(g);
                    }
                    else if ( ckt.getTempSource() != null ) 
                        ckt.getTempSource().draw(g);
                }
            return true;
        }catch (Exception e)    {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); //To change body of generated methods, choose Tools | Templates.
    }

}
