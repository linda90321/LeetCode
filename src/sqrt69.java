/*Implement int sqrt(int x).

Compute and return the square root of x.

Hide Company Tags Bloomberg Apple Facebook
Hide Tags Binary Search Math
Hide Similar Problems (M) Pow(x, n)
 */
/*当target值不在数组中，low指向大于target的那个值，high指向小于target的那个值，由于我们需要向下取整的结果，所以我们返回high指向的值（这里high指向的值和high的值是同一个值），这个值就是所求得最接近起开根号结果的整数值。
 */

public class sqrt69 {
	public int mySqrt(int x) {
		int low = 0;
		int high = x;

		while (low <= high) {
			long mid = (long) (low + high) / 2;
			if (mid * mid < x) {
				low = (int) mid + 1;
			} else if (mid * mid > x) {
				high = (int) mid - 1;
			} else
				return (int) mid;
		}

		return high;
	}
}
