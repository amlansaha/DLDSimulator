package devices;

import java.awt.*;
import java.io.*;
import dldsimulator.*;
        
public class Wire implements Serializable
{
    private boolean state,wdState;
    private Coordinate start, end, mid;
    private Device inRef, outRef;
    
    public Wire()
    {
        start = new Coordinate(0,0);
        end = new Coordinate(0,0);
        mid = new Coordinate(0,0);
        this.state = false;
        this.wdState = false;
        this.inRef = null;
        this.outRef = null;
    }

    public Wire(Coordinate start, Coordinate end, Device inRef, Device outRef) {
        this.start = start;
        this.end = end;
        this.inRef = inRef;
        this.inRef.addOutWire(this);
        this.outRef = outRef;
        this.mid = new Coordinate ((start.x+end.x)/2, (start.y+end.y)/2);
        this.state = false;
    }
    
    
    public void setStart(int x,int y)
    {
        this.start.x = x;
        this.start.y = y;
    }
    
    public void setEnd(int x,int y)
    {
        this.end.x = x;
        this.end.y = y;        
    }
    
    public int getStartX()
    {
        return this.start.x; 
    }
    
    public int getStartY()
    {
        return this.start.y; 
    }
    
    public int getEndX()
    {
        return this.end.x; 
    }
    
    public int getEndY()
    {
        return this.end.y; 
    }
    
    public int getMidX()
    {
        return this.mid.x;
    }
    
    public int getMidY()
    {
        return this.mid.y;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Device getInRef() {
        return inRef;
    }

    public void setInRef(Device inRef) {
        this.inRef = inRef;
    }

    public Device getOutRef() {
        return outRef;
    }

    public void setOutRef(Device outRef) {
        this.outRef = outRef;
    }
    
    public void draw(Graphics g)
    {
        Color c = g.getColor();
        if ( state && MainFrame.mode == ModeEnum.run )    g.setColor(Color.red);
        g.drawLine(start.x, start.y, mid.x, start.y);
        g.drawLine(mid.x, start.y, mid.x, end.y);
        g.drawLine(mid.x, end.y, end.x, end.y);
        g.setColor(c);
    }

    @Override
    public String toString() {
        return "Wire{" + "state=" + state + ", wdState=" + wdState + ", start=" + start + ", end=" + end + ", mid=" + mid + ", inRef=" + inRef + ", outRef=" + outRef + '}';
    }
    
    
}