import java.util.Set;

/*Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Hide Company Tags Google Uber Facebook Amazon Yahoo Bloomberg Pocket Gems
*/
public class WordBreak139 {
	//Recursive
    // Time Limit Exceeded 
    /*
    The solution itself has no problem. However, it will result in Time Limit Exceed at OJ. Let's analyze the time complexity of this solution. For each recursion, we have to check its left and right halves, so two operations per recursion. We do this recursion O(n) times. So the total time complexity is O(2^n). Of course it will exceed the time limit. 
    */
    /*
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.contains(s))
        return true;
        
        for(int i=0;i<s.length();i++){
            String s1 = s.substring(0,i+1);
            if(wordDict.contains(s1)){
            String s2 = s.substring(i+1, s.length());
            if(wordBreak(s2, wordDict))
            return true;
            }
        }
        
        return false;
    }
    */
    /*
    // Time Limit Exceeded
    //Basically it is the same as above, but used the dictionary to compare with the string.
    //Note that it will start result in TLE, but the idea of comparing dictionary word with the string is quite commonly used in many sub-string problems. 
    public boolean wordBreak(String s, Set<String> wordDict) {
        return helper(s,wordDict,0);
    }
    
    public boolean helper(String s, Set<String> set, int start){
        if(start == s.length())
        return true;
        
        for(String word : set){
            int len = word.length();
            if(start + len > s.length())
            continue;
            
            if(s.substring(start, start + len).equals(word)){
                if(helper(s, set, start + len))
                return true;
            }
        }
        
        return false;
    }
    */
    /*
    DP Solution:
The key idea of using DP is using a status array dp[] to mark the status such that dp[i] is true means [0, i) is segmented using the dictionary. So s[0, i) can be segmented if and only if s[0, j) can be segmented AND s[j, i) is in the dictionary. 

Discussion:
So using DP, the time complexity is reduced to O(n^2). The space complexity is O(n) since we used the status array. 
*/

    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null ||s.length()==0)
        return true;
        
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0; j< i;j++){
                if(res[j] && wordDict.contains(s.substring(j,i))){
                    res[i] = true;
                    break;
                }
            }
        }
        
        return res[s.length()];
    }
    /*
    //Alternative Solution using DP:
       public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) return true;
         
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
         
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
             
            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length()) continue;
                 
                if (dp[end]) continue;
                 
                if (s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }
        }
        return dp[s.length()];
    }
    */
}
