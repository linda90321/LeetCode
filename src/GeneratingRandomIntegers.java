import java.util.Random;

/*Given an integer n and a random number generator random.nextInt (which generates a random integer between 0 and x), write a program to generate k (k <= n, constant) distinct integers between 0 and n.
 */
 //http://stackoverflow.com/questions/2576023/algorithm-to-generate-1000-distinct-integers-in-the-range-0-8000
//http://stackoverflow.com/questions/196017/unique-non-repeating-random-numbers-in-o1
//https://www.quora.com/How-can-we-generate-k-unique-random-integers-in-the-range-1-n-with-equal-probablity
//https://www.careercup.com/question?id=9865865
//http://doc.okbase.net/yusiguyuan/archive/123522.html
/*You can do this:

Create a list, 0..1000.
Shuffle the list. (See Fisher-Yates shuffle for a good way to do this.)
Return numbers in order from the shuffled list.*/
public class GeneratingRandomIntegers {
   public void generatingRandomIntegers(int n, int k){
	   int[] arr = new int[n];
	   
	   for(int i=0;i<n;i++){
		   arr[i]=i;
	   }
	   int j=n-1;
	   while(j>0){
		   Random r=new Random();
		   int random=r.nextInt(j);
		   swap(arr,random,j);
		   j--;
	   }
/*	   for(int i=0;i<n;i++){
		   System.out.println(arr[i]);
	   }*/
	   for(int i=0;i<k;i++){
		   System.out.println(arr[i]);
	   }
   }

private void swap(int[] arr, int random, int j) {
	// TODO Auto-generated method stub
	int temp=arr[random];
	arr[random]=arr[j];
	arr[j]=temp;
}

public static void main(String[] args){
	GeneratingRandomIntegers res=new GeneratingRandomIntegers();
	res.generatingRandomIntegers(10,2);
}
}
