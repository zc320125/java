/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarsystemdata;

import java.io.*;
import java.util.*;

/**
 *
 * @author Administrator
 */
public class SolarSystem {
    public static void main(String[] args) throws IOException{
        System.out.println("Planets"+"  "+"Orbits"+"   "+"Mass(kg)"+"     "+"Diam(m)"+"    "+"Mean Distance(m)");
        new Sun();
        new Venus();
        new Earth();
        new Moon();
        }
}
class Planets{
    ArrayList arr = new ArrayList<>();
    public Planets() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("solarsystem.dat");
        BufferedReader br = new BufferedReader(fr);
        Scanner sc = new Scanner(fr);
        while(sc.hasNext()){
            arr.add(sc.next());
        }
        br.close();
    }
}
class Sun {
    public Sun() throws IOException{
    Planets p = new Planets();
    String name = (String) p.arr.get(9);
    String mass = (String) p.arr.get(11);
    String dia = (String) p.arr.get(12);
    String orbit = (String) p.arr.get(10);
    String per = (String) p.arr.get(13);
    String aph = (String) p.arr.get(14);
    double pe = Double.parseDouble(per);
    double ap = Double.parseDouble(aph);
    double mean = (pe+ap)/2;
    System.out.println(name+"      "+orbit+"    "+mass+"   "+dia+"    "+mean );
    }
}
class Venus {
    public Venus() throws IOException{
    Planets p = new Planets();
    String name = (String) p.arr.get(29);
    String mass = (String) p.arr.get(31);
    String dia = (String) p.arr.get(32);
    String orbit = (String) p.arr.get(30);
    String per = (String) p.arr.get(33);
    String aph = (String) p.arr.get(34);
    double pe = Double.parseDouble(per);
    double ap = Double.parseDouble(aph);
    double mean = (pe+ap)/2;
    System.out.println(name+"    "+orbit+"    "+mass+"     "+dia+"    "+mean );
    }
}
class Earth {
    public Earth() throws IOException{
    Planets p = new Planets();
    String name = (String) p.arr.get(39);
    String mass = (String) p.arr.get(41);
    String dia = (String) p.arr.get(42);
    String orbit = (String) p.arr.get(40);
    String per = (String) p.arr.get(43);
    String aph = (String) p.arr.get(44);
    double pe = Double.parseDouble(per);
    double ap = Double.parseDouble(aph);
    double mean = (pe+ap)/2;
    System.out.println(name+"    "+orbit+"    "+mass+"     "+dia+"    "+mean );
    }
}
class Moon {
    public Moon() throws IOException{
    Planets p = new Planets();
    String name = (String) p.arr.get(49);
    String mass = (String) p.arr.get(51);
    String dia = (String) p.arr.get(52);
    String orbit = (String) p.arr.get(50);
    String per = (String) p.arr.get(53);
    String aph = (String) p.arr.get(54);
    double pe = Double.parseDouble(per);
    double ap = Double.parseDouble(aph);
    double mean = (pe+ap)/2;
    System.out.println(name+"    "+orbit+"   "+mass+"    "+dia+"     "+mean );
    }
}


