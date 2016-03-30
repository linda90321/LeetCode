/*242. Valid Anagram My Submissions QuestionEditorial Solution
Total Accepted: 71149 Total Submissions: 171831 Difficulty: Easy
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
import java.util.HashMap;

public class validAnagram242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;

		if (s == null && t == null)
			return true;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int count = map.get(s.charAt(i));
				count++;
				map.put(s.charAt(i), count);
			} else
				map.put(s.charAt(i), 1);
		}

		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				int count = map.get(t.charAt(i));
				count--;
				map.put(t.charAt(i), count);
				if (count < 0)
					return false;
			} else
				return false;
		}

		return true;
	}
}
