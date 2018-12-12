/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import javax.swing.*;

public class Gameoflife extends Thread{
    static byte[][] now;
    static Gameoflife gl;
    static state st;
    static futurestate fs;
    static setcolour sc;
    static setframe sf;
    static JPanel[][] jp;
    public Gameoflife(int width,int height)
    {
        now = new byte[width][height];
        sf = new setframe(width,height);
        jp = sf.jp;
    }
    public static void main(String[] args)
    {
            Gameoflife gl = new Gameoflife(20,20);
            st = new state(now);
            fs = new futurestate(now, jp);
            sc = new setcolour(now, jp);
    }
}
    
