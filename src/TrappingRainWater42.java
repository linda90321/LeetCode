import java.util.Stack;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Hide Company Tags Google Twitter Zenefits Amazon Apple Bloomberg
Hide Tags Array Stack Two Pointers
Hide Similar Problems (M) Container With Most Water (M) Product of Array Except Self
*/
public class TrappingRainWater42 {
    /*
    首先，挨个分析每个A[i]能trapped water的容量，然后将所有的A[i]的trapped water容量相加即可

其次，对于每个A[i]能trapped water的容量，取决于A[i]左右两边的高度（可延展）较小值与A[i]的差值，即volume[i] = [min(left[i], right[i]) - A[i]] * 1，这里的1是宽度，如果the width of each bar is 2,那就要乘以2了”
 

那么如何求A[i]的左右高度呢？ 要知道，能盛多少水主要看短板。那么对每个A[i]来说，要求一个最高的左短板，再求一个最高的右短板，这两个直接最短的板子减去A[i]原有的值就是能成多少水了。

 

所以需要两遍遍历，一个从左到右，找最高的左短板；一个从右到左，找最高的右短板。最后记录下盛水量的总值就是最终结果了。
*/

	public int trap(int[] A) {
		int len = A.length;
		if (len < 3) {
			return 0;
		}

		int area = 0;
		int[] left = new int[len];
		int[] right = new int[len];

		left[0] = A[0];
		right[len - 1] = A[len - 1];
		for (int i = 1; i < len - 1; i++) {
			left[i] = Math.max(left[i - 1], A[i]);
		}
		for (int i = len - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], A[i]);
		}

		for (int i = 0; i < len - 1; i++) {
			area += Math.min(left[i], right[i]) - A[i];
		}

		return area;
	}
	
	public int trapUseStack(int[] A) {
        if(A.length < 3) {
            return 0;
        }
        int cur = 0;
        while(cur < A.length && A[cur] == 0)
        cur++;
        
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(cur < A.length){
            while(!stack.isEmpty() && A[cur] > A[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                break;
                
                area += (cur - stack.peek() - 1) * (Math.min(A[cur],A[stack.peek()]) - A[top]);
                
            }
            
            stack.push(cur);
            cur++;
        }
        
        return area;
    }
}
