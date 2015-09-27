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
public class XOR extends Gate    {

    public XOR(int inputCount) {
        super(inputCount, DeviceEnum.xor, new Coordinate(0,0));
    }
    
    public XOR(int inputCount, Coordinate location) {
        super(inputCount, DeviceEnum.xor, new Coordinate (location.x-80, location.y-30) );
//        System.out.println("Building an XOR gate...");
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);
        g.drawArc(x+30,y+5,20,50,0,-90);
        g.drawArc(x+30,y+5,20,50,0,90);
        g.fillOval(x+98,y+28,4,4);
        this.setOutLeg(new Coordinate(x+100,y+30));
//        g.draw
        int i = this.getInputCount();
        
        if(i == 2)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+20), 0);
            
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+29, 10, 2);
            g.fillOval(x+40, y+28, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+30), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+40), 2);
        }
        
        else if(i == 4) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+9, 6, 2);
            g.fillOval(x+40, y+8, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+10), 0);
            
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+40), 2);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+49, 6, 2);
            g.fillOval(x+40, y+48, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+50), 3);
        }
        else if(i == 5) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+9, 6, 2);
            g.fillOval(x+40, y+8, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+10), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+19, 10, 2);
            g.fillOval(x+40, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+29, 10, 2);
            g.fillOval(x+40, y+28, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+30), 2);
            
            if ( this.getInput(3) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+39, 10, 2);
            g.fillOval(x+40, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+40), 3);
            
            if ( this.getInput(4) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+40, y+49, 6, 2);
            g.fillOval(x+40, y+48, 4, 4);
            this.setInLeg(new Coordinate(x+40,y+50), 4);
        }
    }

    @Override
    public void setLocation(Coordinate cd) {
        super.setLocation(new Coordinate(cd.x-80, cd.y-30));
        System.out.println("XOR location: "+this.getLocation());
    }

    @Override
    public boolean isOnDevice(int x, int y) {
        if ( x >= this.getX()+40 && x <= this.getX()+100 )  {
            if ( y >= this.getY() && y <= this.getY()+60 )  return true;
        }
        return false;
    }

    @Override
    public void generateOutput() {
        int freq = 0, l = getInputCount();
        for ( int i = 0; i < l; i++ )   {
            if ( getInput(i) )  {
                freq++;
            }
        }
        if ( freq != 1 )    this.output = false;
        else    this.output = true;
        
        l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
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
    
}
