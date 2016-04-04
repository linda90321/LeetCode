package indeedPrime;
// indeed -> d
//google -> g
//hulu -> u
import java.util.*;

public class FirstDuplicateElenment {
	public static char duplicate(String s) {
		if (s == null || s.length() == 0)
			return ' ';

		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();

		for (int i = 0; i < s.length(); i++) {
			char cur = s.charAt(i);
			if (map.containsKey(cur)) {
				map.get(cur).set(1, map.get(cur).get(1) + 1);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				temp.add(1);
				map.put(cur, temp);
			}
		}

		char res = ' ';
		int index = Integer.MAX_VALUE;
		for (char c : map.keySet()) {
			if (map.get(c).get(1) >= 2) {

				if (map.get(c).get(0) < index) {
					res = c;
				}

				index = Math.min(map.get(c).get(0), index);
			}
		}

		// return s.charAt(index);
		return res;
	}

	public static void main(String[] args) {
		String s = "indeed";
		System.out.println(duplicate(s));
	}
}
