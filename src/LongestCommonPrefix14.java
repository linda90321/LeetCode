/*Write a function to find the longest common prefix string amongst an array of strings.

Hide Company Tags Yelp
Hide Tags String
 */
public class LongestCommonPrefix14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0 || strs == null)
			return "";

		String res = "";
		for (int i = 0; i < strs[0].length(); i++) {
			String temp = strs[0].substring(0, i + 1);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() < temp.length()
						|| !strs[j].substring(0, i + 1).equals(temp))
					return res;
			}
			res = temp;
		}

		return res;
	}
}
