  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parse;

import java.io.*;
import java.util.*;
import java.util.regex.*;

/**
 *
 * @author Administrator
 */
public class Parse {

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader("shortwords.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("Frankenstein.txt"));
            ArrayList<String> arr = new ArrayList<String>();
            ArrayList<String> arr2 = new ArrayList<String>();
            Scanner sc = new Scanner(br);
            while(sc.hasNext()){
                arr.add(sc.next());
            }
            HashMap<String, Integer> wordCount = new HashMap<>();
            HashMap<String, Integer> wordCount2 = new HashMap<>();
            String line;
            while  ((line = br2.readLine()) != null) {
                String[] words = line.split("[ \\.\\?\\,\\!\\:\\\"\\;\\(\\)\\_]+");
                for (String w : words) {
                    //System.out.print(w+" ");
                    arr2.add(w);
                }
                System.out.println();
            }
            System.out.println();
            for(int j=0;j<arr.size();j++){
                for(int i=1;i<arr2.size();i++){
                    if(arr2.get(i).equals(arr.get(j))){
                        if (wordCount.containsKey(arr2.get(i-1))) {
                            wordCount.put(arr2.get(i-1), wordCount.get(arr2.get(i-1))+1);
                        }
                        Integer count = wordCount.get(arr2.get(i-1));
                        if (count == null){
                            wordCount.put(arr2.get(i-1), 1);
                        }
                        else{
                            wordCount.put(arr2.get(i-1), count);
                        }
                    }
                }
                Set<String> keySet = wordCount.keySet();
                for (Iterator<String> l = keySet.iterator(); l.hasNext(); ) {
                    String key = l.next();
                    if(wordCount.get(key)>=50&&!key.equals("")&&wordCount.get(key)!=null){
                        System.out.println("the occurrences of the word "+key + " before the common word "+arr.get(j)+"==>" + wordCount.get(key));
                    }
                }
            }
            for(int j=0;j<arr.size();j++){
                for(int i=0;i<arr2.size()-1;i++){
                        if(arr2.get(i).equals(arr.get(j))){
                            if (wordCount2.containsKey(arr2.get(i+1))) {
                                wordCount2.put(arr2.get(i+1), wordCount2.get(arr2.get(i+1))+1);
                            }
                            Integer count = wordCount2.get(arr2.get(i+1));
                            if (count == null){
                                wordCount2.put(arr2.get(i+1), 1);
                            }
                            else{
                                wordCount2.put(arr2.get(i+1), count);
                            }
                        }
                }
                Set<String> keySet = wordCount2.keySet();
                for (Iterator<String> l = keySet.iterator(); l.hasNext(); ) {
                    String key = l.next();
                    if(wordCount2.get(key)>=50&&!key.equals("")&&wordCount2.get(key)!=null){
                        System.out.println("the occurrences of the word "+key + " after the common word "+arr.get(j)+"==>" + wordCount2.get(key));
                    }
                }
            }    
        }catch(Exception e){
            System.out.println("Sorry, can't do it!");
            e.printStackTrace();    
        }   
    }
}