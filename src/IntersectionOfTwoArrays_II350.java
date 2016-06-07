/*Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to num2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Subscribe to see which companies asked this question

Hide Tags Binary Search Hash Table Two Pointers Sort
Hide Similar Problems (E) Intersection of Two Arrays
*/
import java.util.*;
public class IntersectionOfTwoArrays_II350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		HashSet<Integer> set = new HashSet<>();
		int index1, index2;
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		for (index1 = 0, index2 = 0; index1 < nums1.length
				&& index2 < nums2.length;) {
			if (nums1[index1] == nums2[index2]) {
				set.add(index1);
				index1++;
				index2++;
			} else if (nums1[index1] < nums2[index2]) {
				index1++;
			} else {
				index2++;
			}

		}
		int[] result = new int[set.size()];
		int i = 0;
		for (Integer index : set) {
			result[i++] = nums1[index];
		}
		return result;
	}

	/*
	    public int[] intersect(int[] nums1, int[] nums2) {
	        
	        HashMap<Integer, Integer>  map= new HashMap<Integer, Integer>();
	        HashMap<Integer, Integer>  res= new HashMap<Integer, Integer>();
	        
	        for(int i=0; i<nums1.length; i++){
	            if(map.containsKey(nums1[i])){
	                map.put(nums1[i], map.get(nums1[i])+1);
	            }else
	            map.put(nums1[i],1);
	        }
	        
	        for(int i=0; i<nums2.length; i++){
	            if(map.containsKey(nums2[i])){
	                if(map.get(nums2[i])-1 > 0){
	                map.put(nums2[i], map.get(nums2[i])-1);
	                }else{
	                map.remove(nums2[i]);    
	                }
	                if(res.containsKey(nums2[i])){
	                    res.put(nums2[i], res.get(nums2[i])+1);
	                }else{
	                    res.put(nums2[i],1);
	                }
	            }
	        }
	        
	        int count = 0;
	        for(int num : res.values()){
	            count += num;
	        }
	        
	        int[] result = new int[count];
	        int i = 0;
	        for(int key : res.keySet()){
	            int value = res.get(key);
	            for(int j = 0;j<value;j++){
	                result[i++] = key;
	            }
	        }
	        
	        return result;
	    }
	    */
}
