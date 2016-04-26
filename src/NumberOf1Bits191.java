/*Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Hide Company Tags Microsoft Apple
Hide Tags Bit Manipulation
Hide Similar Problems (E) Reverse Bits (E) Power of Two (M) Counting Bits
 */
public class NumberOf1Bits191 {
	public int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			n &= n - 1;
			count++;
		}

		return count;
	}
}
