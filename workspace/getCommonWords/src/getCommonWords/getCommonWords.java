package getCommonWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class getCommonWords {

	public ArrayList<String>  getCommonWords_BruteForce(ArrayList<String> list1, ArrayList<String> list2){
	    ArrayList<String> commonlist = new ArrayList<String>();

		for(int i=0;i<list1.size();i++){  
			for(int j=0;j<list2.size();j++){  
				String str1 = list1.get(i).toString();
				String str2 = list2.get(j).toString();
				if(str1.equals(str2)){
				commonlist.add(str1);
				}
			}  
		}  
	    return commonlist;
    }  	
	public ArrayList<String>  getCommonWords_Hash(ArrayList<String> list1, ArrayList<String> list2) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();   
        ArrayList<String> commonlist = new ArrayList<String>();   
        for (String str : list1) {   
            if (!map.containsKey(str)) {   
                map.put(str, Boolean.FALSE);   
            }   
        }   
        for (String str : list2) {   
            if (map.containsKey(str)) {   
                map.put(str, Boolean.TRUE);   
            }   
        }   
  
        for (Entry<String, Boolean> e : map.entrySet()) {   
            if (e.getValue().equals(Boolean.TRUE)) {   
            	commonlist.add(e.getKey());   
            }   
        }   
  
        return commonlist;  
	}
}
