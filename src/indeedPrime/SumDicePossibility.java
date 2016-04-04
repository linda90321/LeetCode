package indeedPrime;
/*这个地里面经没看到过，写一个函数float sumPossibility(int dice, int target)，就是投dice个骰子，求最后和为target的概率。因为总共的可能性是6^dice，所以其实就是combination sum，求dice个骰子有多少种组合，使其和为target。先用brute force的dfs来一个O(6^dice)指数复杂度的，然后要求优化，用dp，最后结束代码写的是两者结合的memorized search吧，面试官走的时候还说了句such a good solution。

Solution:A classic backpack problem. Using DP would solve the problem.
//http://buttercola.blogspot.com/2016/02/indeed-sum-dice-possibility.html
*/public class SumDicePossibility {
/*	//DFS 
 *  time:6^n;
 *  space:6^n;
 * public static float sumPossibility(int n, int target) {
		 int count= helper(n,target);
		 double sumCount=Math.pow(6, n);
		 return (float) (count/sumCount);
		 
	 }
	 public static int helper(int n, int target){
		 if(n == 0 ){
			 if(target==0)
			 return 1;
			 else 
			 return 0;
		 }
		 int count = 0;
		 for(int i=1;i<=6;i++){
			count += helper(n-1,target-i); 
		 }
		 
		 return count;
		 
	 }*/
	//dp
	//  time:n*target;
	 // space:n*target;
	  public static float sumPossibility(int n, int target) {
	        if (n <= 0 || target <= 0) {
	            return 0;
	        }
	         
	        int total = (int) Math.pow(6, n);
	         
	        int[][] dp = new int[n + 1][target + 1];
	        dp[0][0] = 1;
	         
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= target; j++) {
	                for (int k = 1; k <= 6; k++) {
	                    if (j >= k) {
	                        dp[i][j] += dp[i - 1][j - k];
	                    }
	                }
	            }
	        }
	         
	        return (float) dp[n][target] / total;
	    }
	 
    public static void main(String[] args) {
        float result = sumPossibility(2, 3);
         
        System.out.println(result);
    }
}
