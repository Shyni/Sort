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
        
        try {
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
/*
 Key = AK1, Value = Code
Key = AK2, Value = ok4
Key = AK3, Value = Adoption Rules
Key = AK4, Value = ok3
Key = AK5, Value = ok2
Key = AK6, Value = ok1
Key = AK7, Value = CINA-
{AK1=Code, AK2=ok4, AK3=Adoption Rules, AK4=ok3, AK5=ok2, AK6=ok1, AK7=CINA-}
* 
* Key = AK1, Value = Code
Key = AK10, Value = Cina
Key = AK11, Value = Cina1
Key = AK12, Value = Cina2
Key = AK13, Value = Cina3
Key = AK14, Value = Cina4
Key = AK15, Value = Cina5
Key = AK2, Value = State Constitution
Key = AK3, Value = Rules of Civil Procedure
Key = AK4, Value = Rules of Criminal Procedure
Key = AK5, Value = Rules of Evidence
Key = AK6, Value = Rules of Appellate Procedure
Key = AK7, Value = District Court Rules of Civil Procedure
Key = AK8, Value = District Court Rules of Criminal Procedure
Key = AK9, Value = Delinquency Rules
{AK1=Code, AK10=Cina, AK11=Cina1, AK12=Cina2, AK13=Cina3, AK14=Cina4, AK15=Cina5, AK2=State Constitution, AK3=Rules of Civil Procedure, AK4=Rules of Criminal Procedure, AK5=Rules of Evidence, AK6=Rules of Appellate Procedure, AK7=District Court Rules of Civil Procedure, AK8=District Court Rules of Criminal Procedure, AK9=Delinquency Rules}

 */
