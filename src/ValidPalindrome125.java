/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Hide Company Tags Microsoft Uber Facebook Zenefits
Hide Tags Two Pointers String
Hide Similar Problems (E) Palindrome Linked List
 */
public class ValidPalindrome125 {
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		s = s.toUpperCase();
		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			while (start < end && !isValid(s.charAt(start)))
				start++;

			while (start < end && !isValid(s.charAt(end)))
				end--;

			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}

	public boolean isValid(char c) {
		if (c >= '0' && c <= '9')
			return true;

		if (c >= 'A' && c <= 'Z')
			return true;

		return false;
	}
}
