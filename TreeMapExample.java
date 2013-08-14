/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author User
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
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
          Map<String, String> testTreeMap = new TreeMap<String, String>(new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				str1 = str1.substring(2,str1.length());
				str2 = str2.substring(2,str2.length());
				Integer integer1 = Integer.valueOf(str1);
				Integer integer2 = Integer.valueOf(str2);
				return integer1.compareTo(integer2);
			}
		});
        
        try {
            prop.load(new FileInputStream("C:\\Users\\User\\Documents\\NetBeansProjects\\JavaApplication1\\src\\sort\\testProp.properties"));
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
                testTreeMap.put(key.replace('"',(char) 32).trim(), prop.getProperty(key).replace('"',(char) 32).trim());             
        }     
 
        //Populate example map with values
         
      /*  testTreeMap.put("AK1", "Code");
        testTreeMap.put("AK7", "CINA-");
        testTreeMap.put("AK3", "Adoption Rules");
        testTreeMap.put("AK6", "ok1");
        testTreeMap.put("AK5", "ok2");
        testTreeMap.put("AK4", "ok3");
        testTreeMap.put("AK2", "ok4"); */        
         
        for (Iterator it = testTreeMap.entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " +
                               entry.getValue());
        }
        System.out.println(testTreeMap); 
    }
}
