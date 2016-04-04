package indeedPrime;
/*Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].*/
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<String>();
        if(nums == null || nums.length ==0)
        return res;
        int start=0;
        for(int i=1;i<nums.length;i++){
        if(nums[i] - nums[i-1] == 1)
        continue;
        else{
            if(start == i-1)
            res.add(nums[start]+"");
            else
            res.add(nums[start] + "->" + nums[i-1]);
            
            start = i;
        }
        }
        
        if(start == nums.length-1 )
        res.add(nums[start]+"");
        else
        res.add(nums[start] + "->" + nums[nums.length-1]);
        
        return res;
    }
    public static void main(String[] args) {
    	int[] nums={-3, -2, 1, 2, 3, 5, 8, 10, 11, 12, 15};
    	SummaryRanges res=new SummaryRanges();
    	System.out.println(res.summaryRanges(nums));
    }
}
