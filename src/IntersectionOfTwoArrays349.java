/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
Subscribe to see which companies asked this question

Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays II
*/
import java.util.*;
public class IntersectionOfTwoArrays349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        
        
        for(int i=0; i< nums2.length; i++){
            if(set.contains(nums2[i])){
            res.add(nums2[i]);
            set.remove(nums2[i]);
            }
        }
        
        int[] result = new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i] = res.get(i);
        }
        
        return result;
    }
}
