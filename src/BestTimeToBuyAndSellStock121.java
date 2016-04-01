/*Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Hide Company Tags Microsoft Bloomberg Uber Facebook
Hide Tags Array Dynamic Programming
Hide Similar Problems (M) Maximum Subarray (M) Best Time to Buy and Sell Stock II (H) Best Time to Buy and Sell Stock III (H) Best Time to Buy and Sell Stock IV (M) Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStock121 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2)
			return 0;
		int maxProfit = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {

			min = Math.min(min, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i] - min);

		}

		return maxProfit;
	}
}
