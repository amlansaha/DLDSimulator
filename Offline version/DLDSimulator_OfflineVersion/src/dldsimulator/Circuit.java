/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import devices.*;
import static dldsimulator.DeviceEnum.not;
import java.io.Serializable;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Circuit implements Serializable{
//    public Device device[];
    
    public boolean pointFlag;
    public ArrayList<Device> device;
    public ArrayList<Source> source;
    public Device temp;
    public Source tempSource;
    public ArrayList<Wire> wire;
    public int countD, countS, countW;  //count = number of gates, countS = number of source
    public Coordinate start, end;
    
    public Circuit() {
//        this.device = new Device[105];
        //TODO make it source
//        this.source = new Source[22];
//        this.wire = wire;
        device = new ArrayList<Device> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Wire>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
    
    public Circuit ( Circuit ckt )  {
        this.device = ckt.device;
        this.source = ckt.source;
//        for ( int i = 0; i < 105; i++ ) device[i] = new Device(ckt.device[i]);
//        for ( int i = 0; i < 22; i++ ) source[i] = new Source(ckt.source[i]);
        this.countD = ckt.countD;
        this.countS = ckt.countS;
        this.countW = ckt.countW;
    }
    public void drawCircuit ( Graphics g)   {
//        System.out.println("Drawing circuit... "+countD);
        countD = device.size();
        for ( int i = 0; i < countD; i++ )  {
            g.setColor(Color.BLACK);
            device.get(i).draw(g);
//            System.err.println("Device number " + i);
        }

        countS = source.size();
        for ( int i = 0; i < countS; i++ )  {
            g.setColor(Color.BLACK);
            source.get(i).draw(g);
        }
        
        countW = wire.size();
        for ( int i = 0; i < countW; i++ )  {
            g.setColor(Color.BLACK);
            wire.get(i).draw(g);
        }
        g.setColor(Color.BLUE);
        drawTempWire(g);
    }
    
    public boolean addWire (Coordinate startingPoint, Device startDevice, Coordinate endingPoint, Device endingDevice )   {
        if ( startDevice == null || endingDevice == null )  {
            JOptionPane.showMessageDialog(null, "Invalid connection.");
            return false;
        }
        if ( startDevice.isOnOutLeg(startingPoint) )    {
            if ( endingDevice.isOnOutLeg(endingPoint) ) {
                JOptionPane.showMessageDialog(null, "You cannot connect 2 output ports.");
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = endingDevice.isOnInLeg(endingPoint);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Invalid connection.");
                    return false;
                }
                if ( endingDevice.setInRef(indx, startDevice) == false )    {
                    JOptionPane.showMessageDialog(null, "This "+endingDevice.getClass().toString()+" device already has an input.\nYou have to remove the previous input line to add a new input.");
                    return false;
                }
                startDevice.addOutRef(endingDevice);
                wire.add(new Wire(startingPoint, endingPoint, startDevice, endingDevice));
                System.out.println("wire is not null: "+(wire.get(0) != null));
            }
        }
        else if ( endingDevice.isOnOutLeg(endingPoint) )    {
            if ( startDevice.isOnOutLeg(startingPoint) ) {
                JOptionPane.showMessageDialog(null, "You cannot connect 2 output ports.");
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = startDevice.isOnInLeg(startingPoint);
                if (indx < -1)  {
                    JOptionPane.showMessageDialog(null, "Invalid connection.");
                    return false;
                }
                if ( startDevice.setInRef(indx, endingDevice) == false )    {
                    JOptionPane.showMessageDialog(null, "This "+startDevice.getClass().toString()+" device already has an input.\nYou have to remove the previous input line to add a new input.");
                    return false;
                }
                endingDevice.addOutRef(startDevice);
                wire.add(new Wire(endingPoint, startingPoint, endingDevice, startDevice));
                System.out.println("wire is not null: "+(wire.get(0) != null));
            }
        }
        return false;
    }
    
    public void drawTempWire (Graphics g) {
        try {
//            System.out.println("Drawing temp wire.");
            int midx = (start.x+end.x)/2;
            midx = (midx+5);
            midx-= midx%10;
//            System.err.println("Successfull :D");

            g.drawLine(start.x, start.y, midx, start.y);
            g.drawLine(midx, start.y, midx, end.y);
            g.drawLine(midx, end.y, end.x, end.y);
        }   catch(Exception e)  {
//            e.printStackTrace();
        }
    }
    
    public void setTemp ( MouseEvent evt, int inputCount )   {
        try {
            Coordinate cd = new Coordinate(evt);
            switch ( MainFrame.currentDev ) {
                case and:
                    if ( temp == null || temp.getType() != DeviceEnum.and ) temp = new AND(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case or:
                    if ( temp == null || temp.getType() != DeviceEnum.or ) temp = new OR(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case not:
                    if ( temp == null || temp.getType() != DeviceEnum.not ) temp = new NOT(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case xor:
                    if ( temp == null || temp.getType() != DeviceEnum.xor ) temp = new XOR(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case nand:
                    if ( temp == null || temp.getType() != DeviceEnum.nand ) temp = new NAND(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case nor:
                    if ( temp == null || temp.getType() != DeviceEnum.not ) temp = new NOR(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case led:
                    if ( temp == null || temp.getType() != DeviceEnum.led ) temp = new LED(cd);
                    else    temp.setLocation(cd);
                    break;
                case source:
                    temp = null;
                    setTempSource (cd);
                    break;
            }
//            System.out.println("Temp("+" has been set.");
        } catch (Exception e)   {
            System.err.println("Error in making temp object...");
            e.printStackTrace();
            temp = null;
        }
        System.gc();
    }
    
    public void setTempSource ( Coordinate cd ) {
        try {
            tempSource = new Source(cd);
        }   catch(Exception e)  {
            e.printStackTrace();
        }
    }
    
    public Device getTemp() {
        return temp;
    }
    
    public Source getTempSource()   {
        return tempSource;
    }
    
    public void placeTemp ()    {
        try {
            if ( temp != null ) {
                device.add(temp);
                countD++;
                temp = null;
            }
            else if ( tempSource != null )  {
                source.add(tempSource);
                countS++;
                tempSource = null;
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Device searchForDevice (Coordinate cd)   {
        for ( int i = 0; i < countD; i++ )
            if ( device.get(i).isOnDevice(cd.x, cd.y) )
                return device.get(i);
        return searchForSource(cd);
    }
    
    public Source searchForSource (Coordinate cd)   {
        for ( int i = 0; i < countS; i++ )
            if ( source.get(i).isOnDevice(cd.x, cd.y))
                return source.get(i);
        return null;
    }
    
    public Wire searchForWire (Coordinate cd)   {
        
        return null;
    }
    
    public boolean isValid()    {
        countD = device.size();
        for ( int i = 0; i < countD; i++ )
            if ( !device.get(i).isValid() ) return false;
        
        return true;
    }
    
    public void clear() {    
        device = new ArrayList<Device> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Wire>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
    
    public boolean deleteDevice (Device d)  {
        d.delete();
        if ( device.remove(d) ) {
            for ( int i = 0; i < wire.size(); i++ ) {
                Wire w = wire.get(i);
                if ( w.getInRef() == d || w.getOutRef() == d )  {
                    if ( wire.remove(i) != null )   i--;
                }
            }
            return true;
        }
        if ( !source.remove(d) )    return false;
        return true;
    }
    
    public String toString()    {
        String str = new String("");
        str+= countD + " " + device.get(0).getX()+" "+device.get(0).getY();
        return str;
    }
    
    public void copy ( Circuit ckt )  {
        this.device = null;
        this.device = ckt.device;
        this.source = null;
        this.source = ckt.source;
        this.wire = null;
        this.wire = ckt.wire;
//        for ( int i = 0; i < 105; i++ ) device[i] = ckt.device[i];
//        for ( int i = 0; i < 22; i++ ) source[i] = ckt.source[i];
        this.countD = device.size();
        this.countS = source.size();
//        this.countW = ckt.countW;
    }
}
