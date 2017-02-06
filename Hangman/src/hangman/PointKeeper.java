/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;


/**
 *
 * @author Y-Uyen
 */
public class PointKeeper {
    private int x;
    private int y;
    
    public PointKeeper() {
        this.x = 0;
        this.y = 0;
    }
    
    public PointKeeper(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
