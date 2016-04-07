/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Greedy
Hide Similar Problems (M) Best Time to Buy and Sell Stock (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStock_II122 {
	public int maxProfitSolution1(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int profit = 0;
		int minIndex = 0;
		int curMaxIndex = 0;
		int i = 1;
		while (i < prices.length) {
			while (i < prices.length && prices[i] > prices[i - 1]) {
				i++;
			}
			curMaxIndex = i - 1;
			profit += prices[curMaxIndex] - prices[minIndex];
			minIndex = i;
			i++;
		}

		return profit;

	}

	// DP
	public int maxProfitSolution2(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] dp = new int[prices.length];
		dp[0] = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1])
				dp[i] = dp[i - 1];
			else
				dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
		}

		return dp[prices.length - 1];
	}
}
