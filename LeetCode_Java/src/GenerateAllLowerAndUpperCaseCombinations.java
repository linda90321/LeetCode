/*
 * 
Given a string generate all possible lower case & upper case combinations of the string
Input: ab
Ouput: ab, aB, Ab, AB
 */

public class GenerateAllLowerAndUpperCaseCombinations {
	public static void comb(String s) {

/*		int combinations = 1 << s.length();
		char[][] c = { s.toUpperCase().toCharArray(),
				s.toLowerCase().toCharArray() };
		char[] res = new char[s.length()];

		for (int i = 0; i < combinations; i++) {
			for (int j = 0; j < s.length(); j++) {
				res[j] = c[(i >> j) & 1][j];
			}
			System.out.println(new String(res));
		}*/
		String sL=s.toLowerCase();
	    String sU=s.toUpperCase();
	    helper(sL, sU, 0, "");
	}
	
	public static void helper(String sL, String sU, int index, String temp){
		if (index==sL.length()){
			System.out.println(temp);
			return;
		} 
		
		helper(sL, sU, index+1,temp+sL.charAt(index));
		helper(sL, sU, index+1,temp+sU.charAt(index));
	}
	
	
	 public static void main(String[] args) {		    
		    String s5="ab";
		    String s6="aB";
		    String s7="AB";
		    String s8="";
		    
		    comb(s5);
		    System.out.println("\n");
		    comb(s6);
		    System.out.println("\n");
		    comb(s7);
		    System.out.println("\n");
		    comb(s8);
		    
		    
		  }
}
