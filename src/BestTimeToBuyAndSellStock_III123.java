/*Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Best Time to Buy and Sell Stock (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock IV
 */
public class BestTimeToBuyAndSellStock_III123 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0)
			return 0;

		int[] left = new int[prices.length];
		int[] right = new int[prices.length];

		helper(prices, left, right);

		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, left[i] + right[i]);
		}

		return maxProfit;
	}

	public void helper(int[] prices, int[] left, int[] right) {
		// find out the maximal profit from 0 to i
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		// Find out the maximal profit from n - 1 to i
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], max - prices[i]);
			max = Math.max(max, prices[i]);
		}

	}
}
