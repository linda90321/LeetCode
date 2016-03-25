import java.util.HashMap;

/*Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */
public class palindromePermutation266 {
	public boolean canPermutePalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}

		int oddCount = 0;
		for (int value : map.values()) {
			if (value % 2 != 0)
				oddCount++;

			if (oddCount > 1)
				return false;
		}

		return true;
	}
}
