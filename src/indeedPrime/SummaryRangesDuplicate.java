package indeedPrime;

import java.util.ArrayList;
import java.util.List;

//For the input containing duplicates, we only need to slightly modify the code that only skips the duplicated numbers as well.
public class SummaryRangesDuplicate {
	public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<String>();
        if(nums == null || nums.length ==0)
        return res;
        int start=0;
        for(int i=1;i<nums.length;i++){
        if(nums[i] - nums[i-1] == 1 || nums[i] == nums[i-1])
        continue;
        else{
            if(start == i-1 || nums[start] == nums[i-1])
            res.add(nums[start]+"");
            else
            res.add(nums[start] + "->" + nums[i-1]);
            
            start = i;
        }
        }
        
        if(start == nums.length-1 ||  nums[start] == nums[nums.length-1])
        res.add(nums[start]+"");
        else
        res.add(nums[start] + "->" + nums[nums.length-1]);
        
        return res;
    }
	   public static void main(String[] args) {
	    	int[] nums={1,1,1,1,3,4};
	    	SummaryRangesDuplicate res=new SummaryRangesDuplicate();
	    	System.out.println(res.summaryRanges(nums));
	    }
}
