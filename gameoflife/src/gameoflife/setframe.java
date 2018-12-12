/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class setframe extends JPanel{
    static state st;
    static JPanel[][] jp;
    static futurestate fs;
    static setcolour sc;
    static Gameoflife gl;
    public setframe (int width ,int height) {
        JFrame f = new JFrame();
        f.setSize(400,400);
        Container c = f.getContentPane();
        JPanel jp1 = new JPanel();
        jp = new JPanel[width][height];
        JMenuBar mb = new JMenuBar();
        f.setJMenuBar(mb);
        JMenu jm = new JMenu("choice");
        mb.add(jm);
        JMenuItem ji1 = new JMenuItem("start");
        jm.add(ji1);
        ji1.addActionListener(new start());
        jp1.setLayout(new GridLayout(width, height, 2, 2));
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                jp[i][j] = new JPanel();
                jp[i][j].setBackground(Color.white);
                jp1.add(jp[i][j]);
            }
        }
        c.add(jp1);
        f.setVisible(true);
    }
    
    class myThread extends Thread{
        public myThread()    {    
        }
        public void run(){
            for (;;)
            {
                gl.fs.judge();
                gl.sc.paint();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    class start implements ActionListener{
            public void actionPerformed(ActionEvent e) {
               gl.st.random(); 
               gl.sc.paint();
               Thread t = new myThread();  
               t.start();  
            }
    }
    
}
