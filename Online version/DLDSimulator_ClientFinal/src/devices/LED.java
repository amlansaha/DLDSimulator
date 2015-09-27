/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

import dldsimulator.*;
import java.awt.*;
/**
 *
 * @author amlansaha
 */
public class LED extends Gate {

    public LED() {
        super(1, DeviceEnum.led, new Coordinate(0,0));
    }
    public LED(Coordinate location) {
        super(1, DeviceEnum.led, new Coordinate(location.x-10,location.y-10));
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(x,y+20,20,10);
        if ( this.selected )    g.setColor(Color.blue);
        g.setColor(c);
        g.drawRect(x,y+20,20,10);
        this.setInLeg(new Coordinate(x+10,y+40),0);
        if ( getInput(0) && MainFrame.mode == ModeEnum.run )  {
            g.setColor(Color.red);
            g.drawLine(x+10,y+30,x+10,y+40);
            g.fillArc(x+3,y,14,40,0,180);
            g.fillOval(x+8, y+38, 4, 4);
        }
        else    {
            g.fillOval(x+8, y+38, 4, 4);
            g.drawLine(x+10,y+30,x+10,y+40);
        }
           
        g.setColor(c);
        g.drawArc(x+3, y, 14, 40, 0, 180);
        
    }

    @Override
    public void setLocation(Coordinate cd) {
        super.setLocation(new Coordinate(cd.x-10,cd.y-10)); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int isOnInLeg(Coordinate c) {
        return super.isOnInLeg(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOnOutLeg(Coordinate c) {
        return false;
    }

    @Override
    public int isOnInLeg(int x, int y) {
        return super.isOnInLeg(x, y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOnOutLeg(int x, int y) {
        return super.isOnOutLeg(x, y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isOnDevice(int x, int y) {
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+40 )  {
                return true;
            }
        }
        else if ( x == this.getX()+10 && y >= this.getY()+40 && y <= this.getY()+10 )  return true;
        return false;
    }

    @Override
    public void removeInRef(int index) {
        super.removeInRef(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getFlag() {
        return super.getFlag(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFlag(boolean b) {
        super.setFlag(b); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generateOutput() {
        super.generateOutput(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
