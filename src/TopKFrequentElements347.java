import java.util.*;

/*Given a non-empty array of integers, return the k most frequent elements.

 For example,
 Given [1,1,1,2,2,3] and k = 2, return [1,2].

 Note: 
 You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 Subscribe to see which companies asked this question

 Hide Tags Hash Table Heap
 Hide Similar Problems (M) Word Frequency (M) Kth Largest Element in an Array
 */

/*public class TopKFrequentElements347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		PriorityQueue<Entity> priorityQueue = new PriorityQueue<Entity>(
				(Collection<? extends Entity>) new EntityCompare());
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				priorityQueue.offer(new Entity(nums[i - 1], count));
				count = 1;
			} else
				count++;
		}

		priorityQueue.offer(new Entity(nums[nums.length - 1], count));

		int size = priorityQueue.size();
		for (int i = 0; i < size && i < k; i++) {
			res.add(priorityQueue.poll().key);
		}

		return res;
	}
}

class Entity {
	Integer key;
	Integer value;

	public Entity(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class EntityCompare implements Comparator {
	@Override
	public int compare(Object a, Object b) {
		Entity e1 = (Entity) a;
		Entity e2 = (Entity) b;
		if (e1.value > e2.value)
			return -1;

		return 1;
	}
}
*/
public class TopKFrequentElements347 {
	//O(n) - Bucket Sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
            map.put(nums[i],map.get(nums[i])+1);
            else
            map.put(nums[i],1);
        }
        
        ArrayList<Integer>[] arrList = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int count = map.get(key);
            if(arrList[count] == null)
            arrList[count] = new ArrayList<Integer>();
            arrList[count].add(key);
        }
        int size = 0;
        for(int i = nums.length; i >= 0; i--){
            if(arrList[i] != null)
            size = arrList[i].size();
            else continue;
            
            for(int j=0; j<size;j++){
            if(k > 0){
            res.add(arrList[i].get(j));
            k--;
            }
            }
        }
        
        return res;
    }
    
}