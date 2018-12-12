/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.awt.*;
import javax.swing.*;

public class setcolour {
    static byte [][] now;
    static JPanel[][] jp;
    public setcolour(byte [][] now,JPanel[][] jp)
    {
        this.now = now;
        this.jp = jp;
    }
    public static void paint()
    {
        for(int i=1;i<now.length;i++)
        {
            for(int j=1;j<now[i].length-1;j++)
            {
                if (now[i][j]==1) {
                jp[i][j].setBackground(Color.black);
                }
                else{
                    jp[i][j].setBackground(Color.white);
                }
            }
        }
    }
}