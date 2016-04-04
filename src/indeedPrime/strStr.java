package indeedPrime;
/*Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class strStr {
/*    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
           }
    
           if (haystack == null || haystack.length() == 0) {
            return -1;
           }
    
           for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            for (j = 0; j < needle.length(); j++) {
             if (haystack.charAt(i + j) != needle.charAt(j)) {
              break;
                   } 
               }
               if (j == needle.length()) {
                return i;
               }
           }
    
           return -1;
       }*/
    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            int start = i;
            for (j = 0; j < needle.length(); j++) {
                if (start < haystack.length() && haystack.charAt(start) == needle.charAt(j)) {
                    start++;
                } else {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
         
        return -1;
    }
}
