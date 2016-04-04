package indeedPrime;

import java.util.ArrayList;
import java.util.List;

/*follow up 就是万一不是连续的。例子 {1，3，5，6，10，14}
要输出 “1-5/2 , 6-14/4”
使用逗号分隔开。
2和4代表的是这些数的差，也就是steps*/
public class SummaryRanges_III {
	public String summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        int diff = 0;
        while(end < nums.length){
            if( end + 1 < nums.length)
                  diff = nums[end+1] - nums[end];
            while(end + 1 < nums.length && nums[end] + diff == nums[end+1]){
                end++;
            }
            if(end == nums.length - 1)
                sb.append(getRange(nums,start,end, diff));
            else
                 sb.append(getRange(nums,start,end, diff)+",");
            end++;
            start = end;
        }
        return sb.toString();
    }
    public String getRange(int[] nums,int start,int end,int steps){
        return (start == end) ? String.valueOf(nums[start]) : nums[start] + "-"+nums[end]+"/"+steps;
    }
    public static void main(String[] args) {
    	int[] nums={1,3,5,6,10,14};
    	SummaryRanges_III res=new SummaryRanges_III();
    	System.out.println(res.summaryRanges(nums));
    }
}
