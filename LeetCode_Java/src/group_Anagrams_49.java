/*Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class group_Anagrams_49 {

    public ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
    	ArrayList<ArrayList<String>> res= new ArrayList<ArrayList<String>>();
        if(strs.length == 0 || strs == null)
        return res;
        
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map= new HashMap<String, ArrayList<String>>();
        for(int i=0;i<strs.length;i++){
            String[] sarr=strs[i].split("");
            Arrays.sort(sarr);
            String ss=Arrays.toString(sarr);
            if(!map.containsKey(ss)){
            ArrayList<String> temp= new ArrayList<String>();
            temp.add(strs[i]);
            map.put(ss,temp);
            }else{
                map.get(ss).add(strs[i]);
            }
        }
        
        for(ArrayList<String> arr : map.values() ){
            if(arr != null)
            res.add(arr);
        }
        
        return res;
    }

}
