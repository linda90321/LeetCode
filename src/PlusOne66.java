/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Hide Company Tags Google
Hide Tags Array Math
Hide Similar Problems (M) Multiply Strings (E) Add Binary
 */
public class PlusOne66 {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = digits[i] + 1;
			if (digits[i] == 10) {
				digits[i] = 0;
			} else {
				return digits;
			}
		}

		int[] newdigit = new int[digits.length + 1];
		newdigit[0] = 1;
		for (int i = 1; i < newdigit.length; i++) {
			newdigit[i] = digits[i - 1];
		}

		return newdigit;

	}
}
