package indeedPrime;

/*There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {
	 public double findMedianSortedArrays(int A[], int B[]) {
	       int m= A.length;
	       int n= B.length;
	       int total=m+n;
	       
	       if(total%2 !=0){
	           return (double)helper(A,0,m-1,B,0,n-1,total/2+1);
	       }
	       else{
	           double x=helper(A,0,m-1,B,0,n-1,total/2);
	           double y=helper(A,0,m-1,B,0,n-1,total/2+1);
	           return (x+y)/2;
	       }
	    }
	    
	    public double helper(int A[], int astart, int aend, int B[], int bstart, int bend, int k ){
	        int m= aend-astart+1;
	        int n= bend-bstart+1;
	        if(m>n)
	        return helper(B,bstart,bend,A,astart,aend,k);
	        if(m==0)
	        return B[k-1];
	        if(k==1)
	        return Math.min(A[astart],B[bstart]);
	        
	        int partA=Math.min(k/2,m);
	        int partB=k-partA;
	        
	        if(A[astart+partA-1] < B[bstart+partB-1])
	        return helper(A,astart+partA,aend,B,bstart,bstart+partB,k-partA);
	        else if(A[astart+partA-1] > B[bstart+partB-1])
	         return helper(A,astart,astart+partA,B,bstart+partB,bend,k-partB);
	         else return A[astart+partA-1];
	    }
}
