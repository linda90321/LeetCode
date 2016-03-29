/*Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces and the words are always separated by a single space.
For example,
Given s = "the sky is blue",
return "blue is sky the".
Could you do it in-place without allocating extra space?*/

/*思路：二次翻转法
（1）翻转句子中的所有的字符
（2）再翻转每个单词中字符的顺序
如果是Java，应该跟面试官指出String是immutable，所以需要用char array来做。
*/
public class reverseWordsInString186 {
	public static void reverseWords(char[] s) {
		helper(s,0,s.length-1);
		int last=0;
		for(int i=0;i<s.length;i++){
			if(s[i] == ' '){
				helper(s,last,i-1);
				last = i+1;
			}
			
		}
		
/*		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}*/
	}
	public static void helper(char[] s, int i, int j){
		while(i<=j){
			char temp =s[i];
			s[i]=s[j];
			s[j]=temp;
			i++;
			j--;
		}
	}
	
	public static void main(String[] args){
		char[] s={'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		reverseWords(s);
	}
}
