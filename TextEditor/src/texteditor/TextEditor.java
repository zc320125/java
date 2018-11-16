/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;

public class TextEditor extends JFrame{
    private JTextArea t; 
    private JTextArea t1;
    private Frame fr;
    private FileDialog fd;
    private File file;
    private Container c;
    private Font f;
    private JMenu m1,m2;
    private JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
    private String dirpath;
    private String filename;
    public TextEditor(String title){
        super(title);
        setSize(800,600);
        f = new Font("Times",Font.PLAIN,18);
        c = getContentPane();
        t = new JTextArea();
        t1 = new JTextArea();
        m1 = new JMenu("File");
        m2 = new JMenu("Build");
        mi1 = new JMenuItem("New");
        mi2 = new JMenuItem("Save");
        mi3 = new JMenuItem("Open");
        mi4 = new JMenuItem("Quit");
        mi5 = new JMenuItem("Complie");
        mi6 = new JMenuItem("Run");
        JMenuBar mb = new JMenuBar();
        mb.add(m1);
        mb.add(m2);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        m2.add(mi5);
        m2.add(mi6);
        c.add(t);
        c.add(t1,BorderLayout.SOUTH);
        JScrollPane js = new JScrollPane(t);
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        js.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        c.add(js);
        setJMenuBar(mb);
        setVisible(true);
        fd = new FileDialog(fr, "Open", FileDialog.LOAD);
        mi3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                OpenFile();
            }
        });
        mi5.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Complie(TextEditor.this).setVisible(true);
              Compile();
        }
    });
        mi4.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
              new Quit(TextEditor.this).setVisible(true);
        }
        });
        
        mi2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
               Save();
          }
    });

    }
    class Complie extends JDialog{
        public Complie(TextEditor frame){
        super(frame,"MyDialog",true);
        setBounds(200,200,200,100);
        Container c = getContentPane();
        JPanel p = new JPanel();
        JLabel jl = new JLabel("Do you want to save?");
        p.add(jl,BorderLayout.CENTER);
        JButton j1 = new JButton("Yes");
        JButton j2 = new JButton("No");
        j1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Save();
            dispose();
        }
    }); 
        j2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }); 
        p.add(j1);
        p.add(j2);
        c.add(p);
    }
}
    
    class Quit extends JDialog{
        public Quit(TextEditor frame){
        setBounds(200,200,200,100);
        Container c = getContentPane();
        JPanel p = new JPanel();
        JLabel jl = new JLabel("Do you want to save?");
        p.add(jl,BorderLayout.CENTER);
        JButton j1 = new JButton("Yes");
        JButton j2 = new JButton("No");
        p.add(j1);
        p.add(j2);
        c.add(p);
        j1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            Save();
            dispose();
        }
    }); 
        j2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }); 
    }
    }
    public void OpenFile(){
        fd.setVisible(true);
        dirpath = fd.getDirectory();
        filename = fd.getFile();
        if (dirpath == null || filename == null){
            return;
        }
        else{
            t.setText(null);
        }
        File file = new File(dirpath, filename);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                t.append(line + "\r\n");
            }
            br.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void Save(){
            String dirpath = this.dirpath;
            String filename = this.filename;
            if (filename != null && dirpath != null) {
            File file = new File(dirpath,filename);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                String text = t.getText();
                bw.write(text);
                bw.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
    }
     public void Compile() {
         String dirpath = this.dirpath;
         String filename = this.filename;
         File file = new File(dirpath, filename);
         try{
            Pattern pa = Pattern.compile("java:\\d+");
            Runtime r = Runtime.getRuntime();
            Process p = r.exec("javac "+file);
            t1.setText("");
            BufferedReader br1 = new BufferedReader(new InputStreamReader(p.getErrorStream(),Charset.forName("GBK")));
            String line = null;
            ArrayList<String> arr = new ArrayList<String>();
            ArrayList<String> arr2 = new ArrayList<String>();
            while ((line = br1.readLine()) != null) {
                t1.append(line + "\r\n");
                Matcher m = pa.matcher(line);
                while(m.find()){
                    arr.add(m.group());;
                }
            }
            String line2 = arr.toString();
            Pattern pa2 = Pattern.compile("\\d+");
            Matcher m2 = pa2.matcher(line2);
            while(m2.find()){
                arr2.add(m2.group());;
            }
            for (int i = 0; i < arr2.size() - 1; i++) {
                for (int j = i + 1; j < arr2.size(); j++) {
                    if (arr2.get(i).equals(arr2.get(j))) {
                        arr2.remove(j);
                    }
                }
            }
            System.out.println(arr2);
            t.addKeyListener(new KeyListener() {
                int i=0;
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_F4){
                    int j = Integer.parseInt(arr2.get(i));
                    try {
                        int k = t.getLineStartOffset(j);
                         t.setCaretPosition(k);
                         i++;
                         if(i==arr2.size()){
                             i=0;
                         }
                    } catch (BadLocationException ex) {
                        Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
            }
        });
            br1.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new TextEditor("text");
    }

}


