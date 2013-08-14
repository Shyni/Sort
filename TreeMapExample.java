/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author shyni_joseph
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;

import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * TreeMap example code.
 */
public class TreeMapExample {
    
   static Properties prop = new Properties();
    public TreeMapExample() {
        super();
    }
 
    public static void main(String[] args) {
        //create an instance of TreeMap to Store Phone Number
        Map testTreeMap = new TreeMap();
        
        /*try {
            prop.load(new FileInputStream("D:/testProp.txt"));
        } catch (IOException ex) {
            Logger.getLogger(TreeMapExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //get the property value and print it out
        Set propKey = prop.entrySet();
        Iterator i = propKey.iterator();

        // Code to populate Note Type and full jurisdiction list

        while(i.hasNext())
        {
                String key = (( Map.Entry )i.next()).getKey().toString();
                System.out.println("Key = " + key);
                //testTreeMap.put(key.getKey().trim(), prop.getProperty(key.getKey()).replace('"',(char) 32).trim());
                testTreeMap.put(key, prop.getProperty(key));
        }  */    
 
        //Populate example map with values
        testTreeMap.put("AK1", 258963147);
        testTreeMap.put("AK5", 5874569);
        testTreeMap.put("AK3", 58963147);
        testTreeMap.put("AK6", 523658);
        testTreeMap.put("AK5", 5333658);
        testTreeMap.put("AK4", 4566878);
        testTreeMap.put("AK2", 852369);
         System.out.println(testTreeMap);
         
        /*testTreeMap.put("AK1", "Code");
        testTreeMap.put("AK5", "CINA-");
        testTreeMap.put("AK3", "Adoption Rules");
        testTreeMap.put("AK6", "ok1");
        testTreeMap.put("AK5", "ok2");
        testTreeMap.put("AK4", "ok3");
        testTreeMap.put("AK2", "ok4");
         
         */
        for (Iterator it = testTreeMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " +
                               entry.getValue());
        }
        System.out.println(testTreeMap); 
    }
}
