import java.util.*;

/*Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Hide Company Tags Bloomberg
Hide Tags Hash Table Two Pointers String
Hide Similar Problems (H) Longest Substring with At Most Two Distinct Characters
*/
public class LongestSubstringWithoutRepeatingCharacters3 {
    /*
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        
        int first = 0;
        int second = 0;
        int res=0;
        while(second < s.length()){
            if(!set.contains(s.charAt(second))){
                set.add(s.charAt(second));
                second++;
                res = Math.max(res,second - first);
            }else{
                while(first < second && s.charAt(first) != s.charAt(second)){
                set.remove(s.charAt(first));
                first++;
                }
                first++;
                second++;
            }
            
        }
        
        return res;
    }
    */
    /*
        public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        int i=0,j=0,res=0,n=s.length();
        while(i< n && j< n ){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return res;
        
    }
    */
    
     public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        return 0;
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int res=0,n=s.length();
        for(int i=0,j=0;j<n;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j))+1,i);//abba
            }
            res=Math.max(res,j-i+1);
            map.put(s.charAt(j),j);
        }
        
        return res;
     }
}
