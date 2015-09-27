package devices;

import dldsimulator.*;
import java.awt.*;

public class NAND extends Gate
{
    private boolean flag;
    
    public NAND(int inputCount)
    {
        super(inputCount, DeviceEnum.nand,new Coordinate(0,0));
    }
    
    public NAND(int inputCount,Coordinate location){
        super(inputCount,DeviceEnum.nand, new Coordinate(location.x-20,location.y-30));
    }
    
    @Override
    public void draw(Graphics g)
    {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        
        g.drawArc(x,y+5,50,50,0,-90);
        g.drawArc(x,y+5,50,50,0,90);
        g.drawLine(x,y+5,x+25,y+5);
        g.drawLine(x,y+55,x+25,y+55);
        g.drawLine(x,y+5,x,y+55);
        g.drawOval(x+50,y+26,8,8);
        g.fillOval(x+58,y+28,4,4);
        this.setOutLeg(new Coordinate(x+60,y+30));
        
        int i = this.getInputCount();
        
        if(i == 2)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 1);
        }
        
        else if(i == 3)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+28, 4, 4);
            this.setInLeg(new Coordinate(x,y+30), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 2);
        }
        
        else if(i == 4) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+8, 4, 4);
            this.setInLeg(new Coordinate(x,y+10), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 2);
            
            if ( this.getInput(3) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+48, 4, 4);
            this.setInLeg(new Coordinate(x,y+50), 3);
        }
        
        else if(i == 5) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+8, 4, 4);
            this.setInLeg(new Coordinate(x,y+10), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+28, 4, 4);
            this.setInLeg(new Coordinate(x,y+30), 2);
            
            if ( this.getInput(3) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 3);
            
            if ( this.getInput(4) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+48, 4, 4);
            this.setInLeg(new Coordinate(x,y+50), 4);
        }
    }
    
    @Override
    public void setLocation(Coordinate cd) {
        super.setLocation(new Coordinate(cd.x-20,cd.y-30)); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean isOnDevice(int x,int y)  {
        int lx = this.getX(), ly = this.getY();
        return (lx <= x && x <= lx+60 && ly <= y && y <= ly+60);
    }
    

    @Override
    public void removeInRef(int i)  {
        //TODO
        Device temp = this.inRef[i];
        this.inRef[i] = this.inRef[--iCount];
        this.inRef[iCount] = null;
    }

    @Override
    public void generateOutput()    {
        int count = 0;
        for(count=0; count < this.inputCount; count++)
        {
            if(this.input[count] == false)
            {
                this.output = true;
                break;
            }
        }
        if(count == this.inputCount)
            this.output = false;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }

    @Override
    public void setFlag(boolean b)  {
    	this.flag = b;
    }
  
    @Override
    public boolean getFlag()
    {
    	return this.flag;
    }    
}
