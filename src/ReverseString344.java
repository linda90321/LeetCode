/*Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

Subscribe to see which companies asked this question

Hide Tags Two Pointers String
Hide Similar Problems (E) Reverse Vowels of a String
*/
public class ReverseString344 {
	public String reverseString(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] sArr = s.toCharArray();
		for (int i = 0; i < sArr.length / 2; i++) {
			char temp = sArr[i];
			sArr[i] = sArr[sArr.length - 1 - i];
			sArr[sArr.length - 1 - i] = temp;
		}

		String res = new String(sArr);

		return res;
	}
}
