/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SortCreator {
        static List dataList = new ArrayList();
        static String str=null;
        static BufferedReader fr=null;
        static Properties prop = new Properties();
        static Map objMap = new HashMap();
        static int startIndex=4;
    
    public static void main(String[] args){
        SortCreator objSortCreator = new SortCreator();
       
        try {     
            fr=new BufferedReader(new FileReader("C:\\Test\\Data.txt"));
            while((str=fr.readLine())!=null){              
                String[] data=str.split("\\|");
                DataBean db = new DataBean();
                db.setLevel(data[0]);
                db.setName(data[1]);
                db.setId(data[2]);
                dataList.add(db);
                if(data[2].equals("123")){
                    objMap.put(startIndex, db);
                }
            }            
        } catch (IOException ex) {
            Logger.getLogger(SortCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        objSortCreator.sortData();
    }

    private void sortData(){
        System.out.println("sortData : dataList.size() : "+dataList.size());
        System.out.println("sortData : objMap.size() : "+objMap.size());
        DataBean db = (DataBean)objMap.get(startIndex);
        
            try {
                prop.load(new FileReader("C:\\Test\\UserPref.txt"));
            } catch (IOException ex) {
                Logger.getLogger(SortCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
         String parent=prop.getProperty("123");
         String[] dataArr = parent.split("\\|");
        List childList = null;
         for (int i = 0; i < dataArr.length; i++) {   
            childList=new ArrayList();
            System.out.println("sortData : user pref : "+dataArr[i]);            
        }

         for (int i = startIndex+1; i < dataList.size(); i++) {      
            DataBean dbean = (DataBean)dataList.get(i);
         
            if(dbean.getLevel().equals("1")){                            
                break;
            }
          
            if(!dbean.getLevel().equals("1") && dbean.getLevel().compareTo("2")>=0){
                childList.add(dbean);
                
                System.out.println("i : "+i+" size() : "+childList.size()+" level : "+dbean.getLevel()+" getName() : "+dbean.getName());
            }           
        }           
    }
    
    
    
}
