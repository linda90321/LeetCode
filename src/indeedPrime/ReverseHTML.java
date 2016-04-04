package indeedPrime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Reverse string except for HTML entities, i.e, A HTML entities must be treated as an entire word without reverse.

e.g. "1234&euro;" => "&euro;4321"
"1234&euro" => "orue&4321"
"1234&euro;567" => "765&euro;4321"

Understand the problem:
Since a HTML entity must start with "&" and end with ";"
This problem can be solved in a two-step approach.
Step 1: reverse non-html tokens, and store the result into a list. For the HTML entity, do not reverse but just store into the result. 
Step 2: construct the final result just concatenate the list in a reverse order.*/

public class ReverseHTML {
	/*//http://buttercola.blogspot.com/2016/01/indeed-reverse-string-except-html-entity.html
	    public String reverseHTML(String s) {
	        if (s == null || s.length() <= 1) {
	            return s;
	        }
	         
	        List<String> tokens = new ArrayList<>();
	        int i = 0;
	        int j = 0;
	         
	        while (j < s.length()) {
	            char c = s.charAt(j);
	            // Case 1: if c != & 
	            if (c != '&') {
	                j++;
	            } else {
	                // step 1: reverse substring before &
	                if (j != 0) {
	                    String token = reverse(s, i, j - 1);
	                    tokens.add(token);
	                }
	                 
	                // step 2: put the html entity into the tokens
	                StringBuffer sb = new StringBuffer();
	                while (j < s.length() && s.charAt(j) != ';') {
	                    sb.append(s.charAt(j));
	                    j++;
	                }
	                 
	                if (j < s.length()) {
	                    sb.append(';');
	                    tokens.add(sb.toString());
	                    // step 3: update i
	                    j++;
	                    i = j;
	                }
	            }
	        }
	         
	        // Reverse the trailing chars
	        if (i < j) {
	            String token = reverse(s, i, s.length() - 1);
	            tokens.add(token);
	        }
	         
	        // Step 2: concatenate the final result
	        StringBuffer result = new StringBuffer();
	        for (i = tokens.size() - 1; i >= 0; i--) {
	            result.append(tokens.get(i));
	        }
	         
	        return result.toString();
	    }
	     
	    private String reverse(String s, int start, int end) {
	        StringBuffer sb = new StringBuffer();
	         
	        while (start <= end) {
	            sb.append(s.charAt(end));
	            end--;
	        }
	         
	        return sb.toString();
	    }
	     */
	//http://www.meetqun.com/thread-11834-1-1.html
	 public String reverse(String str){
	        if (str == null || str.length() == 0) {
	            return "";
	        }
	        char[] arr = str.toCharArray();
	        swap(arr, 0, arr.length - 1);
	        /*HashMap<Integer, Integer> map = new HashMap<>();
	        int start = -1;
	        for (int i = 0 ; i < arr.length; i++) {
	            if (arr[i] == ';') {
	                start = i;
	            }
	            if (arr[i] == '&' && start != -1 ){
	                map.put(start, i);
	                start = -1;
	            }
	        }
	        for (int key: map.keySet()) {
	            swap(arr, key, map.get(key));
	        }*/
	        int last = -1;
	        for (int i = 0 ; i < arr.length; i++) {
	        	if (arr[i] == ';'){
	        		last = i;
	        	}
	        	if(arr[i] == '&' && last != -1){
	        		swap(arr, last,i);
	        		last = -1;
	        	}
	        }
	        return new String(arr);
	    }

	    public void swap(char[] nums, int beg, int end){
	        while (beg < end) {
	            char tmp = nums[beg];
	            nums[beg] = nums[end];
	            nums[end] = tmp;
	            beg++;
	            end--;
	        }
	    }
	    public static void main(String[] args) {
	    	ReverseHTML sol = new ReverseHTML();
	         
	        String s = "1234&&euro;;567";
	        //String s = "&euro4321";
	        String result = sol.reverse(s);
	         
	        System.out.println(result);
	    }
	}

