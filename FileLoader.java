package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileLoader {

  public static  List<DataBean> getDefaultSortedData() {
		List<DataBean> dataList = new ArrayList<DataBean>();
		try {     
		    BufferedReader fr=new BufferedReader(new FileReader("src/resource/Data.txt"));
		    String str;
            while((str=fr.readLine())!=null){              
                String[] data=str.split("\\|");
                DataBean db = new DataBean();
                db.setLevel(data[0]);
                db.setName(data[1]);
                db.setId(data[2]);
                dataList.add(db);
            }            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return dataList;
	}
	
	
	public static Map<String, List<String>> getUserPref() {
		Map<String, List<String>> prefMap = new HashMap<String, List<String>>();
		Properties prop = loadProperty();
       Set<String> pref=prop.stringPropertyNames();
       
       for(String prefParent : pref){
    	  String childOrderString = prop.getProperty(prefParent);
    	  String[] dataArr = childOrderString.split("\\|");
    	  prefMap.put(prefParent, Arrays.asList(dataArr));
       }
       
       return prefMap;
	}


	private static Properties loadProperty() {
		 Properties prop = new Properties();
		try {
		    prop.load(new FileReader("src/resource/UserPref.txt"));
		} catch (IOException ex) {
		   ex.printStackTrace();
		}
		return prop;
	}
}
