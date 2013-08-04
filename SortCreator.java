package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SortCreator {
    
    public static void main(String[] args){
            SortCreator creator = new SortCreator();
        List<DataBean> dataList = FileLoader.getDefaultSortedData();
        Map<String, List<String>> userPrefMap = FileLoader.getUserPref();
        System.out.println("userPrefMap : "+userPrefMap); 
        dataList = creator.getUserPrefferedSortedData(dataList,userPrefMap);
        for (int i = 0; i < dataList.size(); i++) {
            //DataBean dataBean = dataList.get(i);
            System.out.println(dataList.get(i));            
        }       
    }
	private List<DataBean> getUserPrefferedSortedData(List<DataBean> dataList, Map<String, List<String>> userPrefMap) {
		Set<String> userPrefKeys = userPrefMap.keySet();
		Map<String, Integer> userPrefIndex = getIndexOfuserPrefKey(dataList,userPrefKeys);
		Map<String, List<DataBean>> level2ListMap = getAllLevel2List(dataList);
		
		for (String userPrefKey : userPrefKeys) {
			List<String> level2Keys = userPrefMap.get(userPrefKey);
			int index = userPrefIndex.get(userPrefKey)+1;
			 for(String level2Key : level2Keys){
				    List<DataBean>	leve2List = level2ListMap.get(level2Key);
				    if(leve2List!= null){
						dataList.removeAll(leve2List);
						dataList.addAll(index,leve2List);
						index += leve2List.size();
				    }
			 }
		}		
		return dataList;
        }
	private Map<String, List<DataBean>> getAllLevel2List(List<DataBean> dataList) {
		Map<String, List<DataBean>> Level2PrefListMap = new HashMap<String, List<DataBean>>();
		List<DataBean> level2List = null;
		String FordataBeanId = null;
		for(DataBean dataBean :dataList){
				
			if(dataBean.getLevel().equalsIgnoreCase("1")){
				continue;
			}
			
			if(dataBean.getLevel().equalsIgnoreCase("2")){
				FordataBeanId = dataBean.getId();
				level2List = new ArrayList<DataBean>();
			}
			
			level2List.add(dataBean);
			Level2PrefListMap.put(FordataBeanId,level2List);
		}
                System.out.println("getAllLevel2List : Level2PrefListMap : "+Level2PrefListMap);
		return Level2PrefListMap;
	}


	private static Map<String, Integer> getIndexOfuserPrefKey(List<DataBean> dataList, Set<String> userPrefKeys) {
		Map<String, Integer> userPrefKeyIndex = new HashMap<String, Integer>();
		for(int i = 0;i< dataList.size();i++)
			if(userPrefKeys.contains(dataList.get(i).getId())) userPrefKeyIndex.put(dataList.get(i).getId(), i);
                System.out.println("getIndexOfuserPrefKey : userPrefKeyIndex : "+userPrefKeyIndex);
		return userPrefKeyIndex;
	}

    
}
