/*Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Hide Company Tags LinkedIn Facebook
Hide Tags Array
Hide Similar Problems (H) Trapping Rain Water (M) Maximum Product Subarray (H) Paint House II
*/
public class ProductOfArrayExceptSelf238 {
	/*
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length == 0 || nums == null)
        return res;
        
        int product = 1;
        int countZero = 0;
        int indexZero = 0;
        boolean hasZero = false;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
            hasZero = true;
            countZero++;
            indexZero = i;
            if(countZero >= 2)
            return res;
            continue;
            }else{
                product *= nums[i];
            }
            
        }
        
        for(int i=0;i<nums.length;i++){
            if(hasZero){
            if(i == indexZero)
            res[i] = product;
            else
            res[i]=0;
            }else{
            res[i] = product / nums[i];
            }
        }
        
        return res;
    }
*/
/*
由于output[i] = (x0 * x1 * ... * xi-1) * (xi+1 * .... * xn-1)

因此执行两趟循环：

第一趟正向遍历数组，计算x0 ~ xi-1的乘积

第二趟反向遍历数组，计算xi+1 ~ xn-1的乘积
*/
	
	//without division
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        res[0] = 1;
        
        
        for(int i=1;i<n;i++){
            res[i] = res[i-1]*nums[i-1];  
        }
        
        int right = 1;
        for(int i=n-1;i>=0;i--){
            res[i] *= right;
            right *= nums[i] ;
        }
        
        return res;
        
    }
}
