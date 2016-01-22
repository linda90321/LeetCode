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
				if (count == 0)
					map.remove(t.charAt(i), 0);
			} else
				return false;
		}

		return map.size() == 0;
	}
}
