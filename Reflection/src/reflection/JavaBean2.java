/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reflection;

/**
 *
 * @author Administrator
 */
public class JavaBean2 extends Object {
        private String firstName, lastName;
        public JavaBean2() { }    
        public void setFirstName(String name) { firstName = name; }
        public String getFirstName() { return firstName; }
        public void setLastName(String name) { lastName = name; }
        public String getLastName() { return lastName; }
        public String toString() { 
            if(firstName==null){
                return "lastname: "+lastName;
            }
            if(lastName==null){
                return "firstname: "+firstName;
            }
            return null;
        }
    }
