/*Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Hide Company Tags Twitter
Hide Tags Math String
Hide Similar Problems (E) Roman to Integer (H) Integer to English Words
 */
public class IntegerToRoman12 {
	public String intToRoman(int num) {
		String data[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int value[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 }, base = -1;
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < value.length; i++) {
			if (num / value[i] != 0) {
				base = num / value[i];
				while (base != 0) {
					res.append(data[i]);
					base--;
				}
				num = num % value[i];
			}
		}

		return res.toString();
	}
}
