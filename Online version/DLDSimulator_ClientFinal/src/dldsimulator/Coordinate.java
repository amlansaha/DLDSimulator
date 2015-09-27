/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dldsimulator;

import java.awt.event.MouseEvent;
import java.io.Serializable;

/**
 *
 * @author amlansaha
 */
public class Coordinate implements Serializable{

    public int x, y;

    public Coordinate() {
        x = 0;
        y = 0;
    }

    public Coordinate(int x, int y) {
        this.x = x - x % CircuitPanel.distance;
        this.y = y - y % CircuitPanel.distance;
    }

    public Coordinate(MouseEvent evt) {
        if ( evt == null )  {
            x = 0;
            y = 0;
        }
        else    {
            x = evt.getX() - evt.getX() % CircuitPanel.distance;
            y = evt.getY() - evt.getY() % CircuitPanel.distance;
        }
    }
    
    public Coordinate(Coordinate coord) {
        if ( coord == null )    {
            x = 0;
            y = 0;
        }
        else    {
            x = coord.x;
            y = coord.y;
        }
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
    
    
}