/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.awt.*;
import javax.swing.*;

public class futurestate {
    private byte[][] now;
    JPanel[][] jp;
    public futurestate(byte[][] now,JPanel[][] jp)
    {
        this.now = now;
        this.jp = jp;
    }
    public void judge() {
        for (int i = 1; i < now.length - 1; i++) {
            for (int j = 1; j < now[i].length - 1; j++) {
                int Count = 0;
                if (jp[i - 1][j - 1].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i - 1][j].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i - 1][j + 1].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i][j - 1].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i][j + 1].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i + 1][j - 1].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i + 1][j].getBackground() == Color.black) {
                    Count++;
                }
                if (jp[i + 1][j + 1].getBackground() == Color.black) {
                    Count++;
                }
                if (Count==3) {
                    now[i][j] = 1;
                }
                else if (Count == 2) {
                    now[i][j] = now[i][j];
                }
                else 
                    now[i][j] = 0;
            }
        }
    }
}