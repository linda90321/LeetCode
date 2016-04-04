package indeedPrime;

public class ReverseString {
	
/* reverse Words in String   
 * //time complexity:O(s.length());
    //space:O(s.length());
    public String reverseWords(String s) {
      if(s.length()== 0 || s == null)
      return "";
      
      StringBuilder sb=new StringBuilder();
      String[] sArr=s.split(" ");
      for(int i=sArr.length-1;i>=0;i--){
          if(!sArr[i].equals(""))
          sb.append(sArr[i]).append(" ");
      }
      
      return sb.length()==0? "":sb.substring(0,sb.length()-1);
    }*/
	
	public String reverse(String s){
		char[] sArr=s.toCharArray();
		swap(sArr,0,sArr.length);
		s=new String(sArr);
		return s;
	}
	
    public static void swap(char[] s , int i,int j){
        while(i<=j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
}
}
