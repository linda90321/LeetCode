/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Hide Company Tags Adobe Apple
Hide Tags Dynamic Programming
 */
public class ClimbingStairs70 {
	public int climbStairs(int n) {
		if (n < 2)
			return n;

		int[] res = new int[n + 1];
		res[0] = 0;
		res[1] = 1;
		res[2] = 2;

		for (int i = 3; i < n + 1; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		return res[n];
	}
}
