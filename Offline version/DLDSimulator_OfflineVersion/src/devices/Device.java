package devices;

import java.awt.*;
import java.io.*;
import dldsimulator.*;
import java.util.ArrayList;

public class Device implements Serializable
{
    protected int inputCount;
    protected Coordinate location;
    protected DeviceEnum type;
    protected boolean selected;
    
    public Device(){}
    public Device(int inputCount,DeviceEnum de,int locationX,int locationY)
    {
        this.inputCount = inputCount;
        this.location = new Coordinate(locationX, locationY);
        this.type = de;
    }
    public Device(int inputCount,DeviceEnum de,Coordinate location) {
        this.inputCount = inputCount;
        this.location = new Coordinate(location);
        this.type = de;
    }
    public void setInputCount(int i)    {
        this.inputCount = i;
    }
 
    public void setLocation(Coordinate cd)    {
        location = cd;
    }
    
    public final Coordinate getLocation()    {
        return location;
    }
    
    public final void setX(int i)    {
        this.location.x = i;
    }
    
    public final void setY(int i)    {
        this.location.y = i;
    }
    
    public final int getInputCount()    {
        return inputCount;
    }
    
    public final int getX()    {
        return location.x;
    }
    
    public final int getY()    {
        return location.y;
    }
    
    public boolean isSelected()    {return selected;}
    public void setSelected(boolean b)   {selected = b;}
    
    public void draw(Graphics g){}
    
    /**
     *
     * @param c
     * @return the index(0-based) of the input whose coordinate is equal to c. If no such index is found it returns -1.
     */
    public int isOnInLeg(Coordinate c){return isOnInLeg(c.x,c.y);}
    public boolean isOnOutLeg(Coordinate c){return isOnOutLeg(c.x,c.y);}
    
    /**
     * 
     * @param x
     * @param y
     * @return The index of the input leg which is on Coordinate (x,y). Returns -1 if no such leg is found.
     */
    public int isOnInLeg(int x,int y)   {
        int in = this.getInputCount();
//        System.out.println("inputCount: "+in);
        for ( int i = 0; i < in; i++ )  {
            Coordinate c = this.getInLeg(i);
//            System.err.println("inleg is null: "+(c==null));
            if ( c.x == x && c.y == y ) return i;
        }
        return -1;
    }
    
    
    /**
     * 
     * @param x
     * @param y
     * @return true if Coordinate(x,y) is on the output leg of the device, false otherwise;
     */
    public boolean isOnOutLeg(int x,int y){
        Coordinate c = this.getOutLeg();
        return ( c.x == x && c.y == y );
    }
    
    /**
     * 
     * @param x
     * @param y
     * @return true if Coordinate(x,y) is on the device, false otherwise;
     */
    public boolean isOnDevice(int x,int y){return false;}
    
    public boolean setInRef(int index, Device dref){return true;}
    public boolean delete() {return false;}
    
    public void removeInRef(int index){}
    public Device getInRef(int index){return null;}
    public void addOutRef(Device dref){}
    public void addOutWire(Wire w)  {}
    public boolean removeOutRef(Device d)  {return false;}
    public boolean removeOutWire (Wire w)   {return false;}
    public ArrayList getOutRef(){return null;}
//    public void setLegLocation(){}
    public int getInX(int index){return -1;}
    public int getInY(int index){return -1;}
    public int getOutX(){return -1;}
    public int getOutY(){return -1;}
    public void setFlag(){};
    public boolean getFlag(){return false;}
    public void setFlag(boolean b){}
    public final void setType(DeviceEnum de)  {
        this.type = de;
    }    
    public final DeviceEnum getType()    {
        return this.type;
    }
    public void setIn(int index,boolean i) {}
//    public int getIn(int index) {return -1;}
    public boolean getInput(int index){return false;}
    public void generateOutput(){}
    public boolean getOutput(){return false;}
    public void setInput(){}
    public boolean isValid()    {return true;}
    public void setInLeg (Coordinate c, int i) {}
    public Coordinate getInLeg(int i) {return null;}
    public void setOutput(boolean b) {}
    public void setOutLeg (Coordinate c) {}
    public Coordinate getOutLeg() {return null;}
}
