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
public class NOR extends Gate    {

    public NOR(int inputCount) {
        super(inputCount, DeviceEnum.nor, new Coordinate(0,0));
    }
    
    public NOR(int inputCount, Coordinate location) {
        super(inputCount, DeviceEnum.nor, new Coordinate(location.x-80,location.y-30));
        System.out.println("Building an NOR gate...");
    }

    @Override
    public void draw(Graphics g) {
        System.out.println("Printing NOR gate.");
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);
        g.drawOval(x+100, y+26, 8, 8);
        g.fillOval(x+108,y+28,4,4);
        this.setOutLeg(new Coordinate(x+110,y+30));
//        g.draw
        int i = this.getInputCount();
        
        if(i == 2)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+29, 10, 2);
            g.fillOval(x+48, y+28, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+30), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 2);
        }
        
        else if(i == 4) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+9, 6, 2);
            g.fillOval(x+48, y+8, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+10), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 2);
            
            if ( this.getInput(3) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+49, 6, 2);
            g.fillOval(x+48, y+48, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+50), 3);
        }
        else if(i == 5) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+9, 6, 2);
            g.fillOval(x+48, y+8, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+10), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+29, 10, 2);
            g.fillOval(x+48, y+28, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+30), 2);
            
            if ( this.getInput(3) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 3);
            
            if ( this.getInput(4) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+49, 6, 2);
            g.fillOval(x+48, y+48, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+50), 4);
        }
    }

    @Override
    public void setLocation(Coordinate cd) {
        new Coordinate(cd.x-80,cd.y-30);
    }
    
    @Override
    public boolean isOnDevice(int x, int y) {
        if ( x >= this.getX()+50 && x <= this.getX()+110)   {
            if ( y >= this.getY() && y <= this.getY()+60 )
                return true;
        }
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
        
        int count = 0;
        for(count=0; count < this.inputCount; count++)
        {
            if(this.input[count])
            {
                this.output = false;
                break;
            }
        }
        if(count == this.inputCount)
            this.output = true;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }

    
}
