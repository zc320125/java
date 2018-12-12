/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

public class state{
    static byte[][] now;
    static int num;
    public state(byte[][] now)
    {
        this.now = now;
    }
    public void random()
    {
        for(int i=1;i<now.length;i++)
        {
            for(int j=1;j<now[i].length-1;j++)
            {
                num = (int) (Math.random()*10);
                if (num<5) {
                    now[i][j] = 0;
                }
                else
                    now[i][j] = 1;
            }
        }
    }
}
