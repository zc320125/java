/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;

public class Reflection extends JFrame{
    private JTextField jt1 = new JTextField("FirstName:");
    private JTextField jt2 = new JTextField("LastName:");
    private String className = "reflection.JavaBean2";
    public Reflection() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        super("Bean Editor");
        jt1.setCaretPosition(10);
        jt2.setCaretPosition(9);
        Container ct = getContentPane();
        JPanel p = new JPanel();
        ct.add(p, BorderLayout.CENTER);
        p.setLayout(new GridLayout(2, 1));
        p.add(jt1);
        p.add(jt2);
        ct.add(p);
        setSize(400,300);
        setVisible(true);
        buildGettersSetters();
        Class c = Class.forName(className);
        Constructor constructor = c.getConstructor();
        Object obj1 = constructor.newInstance();
        Object obj2 = constructor.newInstance();
        jt1.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        Method m = c.getMethod("setFirstName", java.lang.String.class);
                        m.invoke(obj1, jt1.getText().substring(10));
                        System.out.println(obj1);
                        System.out.println(obj2);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }                
        });
        jt2.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    try {
                        Method m = c.getMethod("setLastName", java.lang.String.class);
                        m.invoke(obj2, jt2.getText().substring(9));
                        System.out.println(obj1);
                        System.out.println(obj2);
                   } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchMethodException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SecurityException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }                
        });
        }
    public static void buildGettersSetters() throws NoSuchMethodException, ClassNotFoundException {
        String className = "reflection.JavaBean2";
        Class c = Class.forName(className);
        Constructor constructor = c.getConstructor();
        Method[] methods = c.getMethods();
        ArrayList<String> getters = new ArrayList<>();
        HashMap<String, Method> setters = new HashMap<>();
        for (int i = 0; i < methods.length; i++) {
            String name = methods[i].getName();
            if (name .startsWith("get"))
                getters.add(name);
            else if (name.startsWith("set"))
                setters.put(name, c.getMethod(name, String.class));
        }
        System.out.println("The get methods are: ");
        for(int i=0; i<getters.size(); i++){
            System.out.println(getters.get(i));
        }
        System.out.println("The set methods are:");
        Set<String> keySet = setters.keySet();
        for (Iterator<String> l = keySet.iterator(); l.hasNext(); ) {
            String key = l.next();
            System.out.println(key);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        new Reflection();
    }

}
