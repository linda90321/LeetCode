/*Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Hide Company Tags Amazon Microsoft Bloomberg
Hide Tags String
Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation (H) Palindrome Pairs
 */
public class LongestPalindromicSubstring5 {
	/*
	 * // O(n^3) public static String longestPalindrome(String s) { if (s ==
	 * null || s.length() == 0) return "";
	 * 
	 * String res = ""; int maxLen = Integer.MIN_VALUE;
	 * 
	 * for (int i = 0; i < s.length(); i++) { for (int j = i + 1; j <
	 * s.length(); j++) { // System.out.println("test"); int len = j - i; String
	 * temp = s.substring(i, j + 1);
	 * 
	 * if (isPalindrome(temp)) { if (len > maxLen) { res = temp; maxLen = len; }
	 * } } }
	 * 
	 * return res; }
	 * 
	 * public static boolean isPalindrome(String s) { int l = 0; int r =
	 * s.length() - 1; while (l <= r) { if (s.charAt(l) != s.charAt(r)) return
	 * false;
	 * 
	 * l++; r--; }
	 * 
	 * return true; }
	 * 
	 * public static void main(String[] agrs) { String s = "aa";
	 * System.out.println(longestPalindrome(s)); }
	 */

	/*
	 * 是对于每个子串的中心（可以是一个字符，或者是两个字符的间隙，比如串abc,中心可以是a,b,c,或者是ab的间隙，bc的间隙，例如aba是回文，
	 * abba也是回文，这两种情况要分情况考虑）往两边同时进
	 * 行扫描，直到不是回文串为止。假设字符串的长度为n,那么中心的个数为2*n-1(字符作为中心有n个，间隙有n-1个）。对于每个中心往两边扫描的复杂
	 * 度为O(n),所以时间复杂度为O((2*n-1)*n)=O(n^2),空间复杂度为O(1)。
	 */
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;

		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String temp = helper(s, i, i);
			if (temp.length() > res.length())
				res = temp;

			temp = helper(s, i, i + 1);
			if (temp.length() > res.length())
				res = temp;
		}

		return res;
	}

	public String helper(String s, int begin, int end) {

		while (begin >= 0 && end <= s.length() - 1
				&& s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}

		return s.substring(begin + 1, end);
	}
}
