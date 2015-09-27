package devices;

import dldsimulator.Coordinate;
import dldsimulator.DeviceEnum;
import java.awt.*;
import java.util.ArrayList;

public class Gate extends Device
{
//    private int input[];
//    private int output;
    private Coordinate inLeg[];
    private Coordinate outLeg;
    protected ArrayList<Device> outRef;
    protected ArrayList<Wire> outWire;
    protected Device inRef[];
    protected int iCount;
    protected boolean input[];
    protected boolean output=false;
    
    public Gate(int inputCount, DeviceEnum de, Coordinate location) {
        super(inputCount, de, location);
        this.input = new boolean[5];
        iCount = 0;
        for ( int i = 0; i < inputCount; i++ )  input[i] = false;
        output = false;
        this.inLeg = new Coordinate[5];
        outRef = new ArrayList();
        outWire = new ArrayList();
        inRef = new Device[5];
        selected = false;
        
        for(int count = 0; count < inputCount; count++) {
            inRef[count] = null;
            input[count] = false;
            Wire w = new Wire();
        }
    }
    
    
    @Override
    public final void setInputCount(int inc)    {
        this.inputCount = inc;
    }
    /**
     * 
     * sets the input values from respected references.
     */
    @Override
    public final void setInput()  {
        for(int count = 0;count < this.getInputCount();count++)
        {
            this.input[count] = this.inRef[count].getOutput();
        }
        System.out.println("Generating input for "+this.getClass().toString());
        this.generateOutput();
        this.setOutWireState();
    }
    
    @Override
    public final void setIn(int index,boolean i)  {
        this.input[index] = i;
        this.generateOutput();
        this.setOutWireState();
    }
    
    @Override
    public final void setOutput(boolean b)   {
        this.output = b;
        this.generateOutput();
        this.setOutWireState();
    }
    
    public final void setOutWireState()  {
        int l = outWire.size();
        for ( int i = 0; i < l; i++ )   {
            outWire.get(i).setState(this.getOutput());
        }
    }
    /**
     *
     * @param index
     * @return The input value of input number "index".
     */
    @Override
    public final boolean getInput(int index) {
        return this.input[index];
    }
    
    @Override
    public final int getInX(int index)    {
        return this.inLeg[index].x;
    }
    
    @Override
    public final int getInY(int index)    {
        return this.inLeg[index].y;
    }
    
    @Override
    public final int getOutX()    {
        return this.outLeg.x;
    }
    
    @Override
    public final int getOutY()    {
        return this.outLeg.y;
    }
    
    @Override
    public final boolean getOutput() {
        return this.output;
    }
    
    
    @Override
    public final boolean setInRef(int index, Device d)  {
        if ( inRef[index] == null ) inRef[index] = d;
        else return false;
        return true;
    }
    
    @Override
    public final void setInLeg (Coordinate c, int i)    {
        inLeg[i] = c;
    }
    /**
     *
     * @param i
     * @return Coordinate of input point number i
     */
    @Override
    public final Coordinate getInLeg(int i) {
        return inLeg[i];
    }

    @Override
    public final void setOutLeg(Coordinate c) {
        this.outLeg = c;
    }
    
    @Override
    public final Coordinate getOutLeg() {
        return outLeg;
    }

    @Override
    public boolean isValid() {
        for ( int i = 0; i < inputCount; i++ )
            if ( inRef[i] == null ) return false;
        return true;
    }

    @Override
    public final Device getInRef(int index) {
        return inRef[index];
    }

    @Override
    public final void addOutRef(Device dref) {
        outRef.add(dref);
    }

    @Override
    public void addOutWire(Wire w) {
        outWire.add(w);
    }

    
    @Override
    public final boolean removeOutRef (Device ref)  {
        int l = outRef.size();
        for ( int i = 0; i < outRef.size(); i++ )   {
            if ( outRef.get(i) == ref )    {
                if ( outRef.remove(i) == null )    {
                    System.out.println("Wire could not be removed.");
                }
            }
            else    {
                i--;
            }
        }
        return outRef.remove(ref);
    }
    
    @Override
    public final ArrayList getOutRef() {
        return outRef;
    }

    @Override
    public void removeInRef(int index) {
        inRef[index] = null;
    }
    
    
    @Override
    public final boolean delete() {
        int inc = this.getInputCount();
        for ( int i = 0; i < inc; i++ ) {   //this will remove the input references and corresponding output references
            Device d = this.getInRef(i);
            if ( d != null )    {
                d.removeOutRef(this);
            }
        }
        int l = 0;
        if ( outRef != null )   {
            for ( int i = 0; i < outRef.size(); i++ )   {   //this will remove the output references and corresponding input references
                Device d = outRef.get(i);
                        System.out.println("Removing input reference of device: "+d.getClass());
                for ( int j = 0; j < d.getInputCount(); j++ )   {
                    if ( d.getInRef(j) == this )    {
                        d.removeInRef(j);
                    }
                }
            }
        }
        
        l = outWire.size();
        outWire.clear();
        outWire = null;
        outRef.clear();
        outRef = null;
        return true;
    }
    
    
}
