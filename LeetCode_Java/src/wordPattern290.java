import java.util.HashMap;
/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class wordPattern290 {
	public boolean wordPattern(String pattern, String str) {
		if ((pattern.length() == 0 && str.length() != 0)
				|| (pattern.length() != 0 && str.length() == 0))
			return false;

		String[] tempPattern = pattern.split("");
		String[] tempStr = str.split(" ");

		if (tempPattern.length != tempStr.length)
			return false;

		HashMap<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < tempPattern.length; i++) {
			if (map.containsKey(tempPattern[i])) {
				if (map.get(tempPattern[i]).equals(tempStr[i]))
					continue;
				else
					return false;
			} else {
				/*
				 * "abba" "dog dog dog dog"
				 */
				if (!map.containsValue(tempStr[i]))
					map.put(tempPattern[i], tempStr[i]);
				else
					return false;
			}
		}

		return true;
	}
}
