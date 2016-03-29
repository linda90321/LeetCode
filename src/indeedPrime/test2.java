package indeedPrime;

public class test2 {
    static void count_Squares(String[] arr) {
        if(arr.length ==0 || arr == null)
            return;
        for(int k=0;k<arr.length;k++){
            String[] temp=arr[k].split(" ");    
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int res=0;
            res= (int)Math.floor(Math.sqrt(end)) - (int)Math.ceil(Math.sqrt(start)) +1;
 
            System.out.println(res);
        }
    }

/*    static boolean isSqrt(int x){
        int low=0;
        int high=x;
        while(low<=high){
        long mid=(long)(low+high)/2;
        if(mid*mid==x)
        return true;
        else if(mid*mid<x)
        low=(int)mid+1;
        else if(mid*mid>x)
        high=(int)mid-1;
        }
        return false;
    }
    
    public final static boolean isSquare(int number)
    {
        int sqrt = (int) Math.sqrt(number);
        if(sqrt*sqrt == number) {
            return true;
        }else {
            return false;
    }
    }*/


    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String[] arr = {"3 9","17 24"};
   count_Squares(arr);
	}
}
