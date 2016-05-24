import java.util.*;

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
Hide Company Tags Amazon Bloomberg Uber Facebook Yelp
Hide Tags Hash Table String
Hide Similar Problems (E) Valid Anagram (E) Group Shifted Strings
*/
public class GroupAnagrams49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (strs == null || strs.length == 0)
			return res;

		Arrays.sort(strs);
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			char[] strArr = str.toCharArray();
			Arrays.sort(strArr);
			String orderString = new String(strArr);
			if (map.containsKey(orderString)) {
				ArrayList<String> arrList = map.get(orderString);
				arrList.add(strs[i]);
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(strs[i]);
				map.put(orderString, temp);
			}
		}

		for (ArrayList<String> arrList : map.values()) {
			if (arrList != null)
				res.add(arrList);
		}

		return res;
	}
}
