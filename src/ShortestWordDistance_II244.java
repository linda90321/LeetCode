/*This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?

Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Hash Table Design
Hide Similar Problems (E) Merge Two Sorted Lists (E) Shortest Word Distance (M) Shortest Word Distance III
 */
import java.util.*;

public class ShortestWordDistance_II244 {
	private HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	public void WordDistance(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				map.get(words[i]).add(i);
			} else {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(words[i], temp);
			}
		}
	}

	public int shortest(String word1, String word2) {
		int min = Integer.MAX_VALUE;
		ArrayList<Integer> list1 = map.get(word1);
		ArrayList<Integer> list2 = map.get(word2);
		int i = 0, j = 0, n1 = list1.size(), n2 = list2.size();
		while (i < n1 && j < n2) {
			min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
			if (list1.get(i) < list2.get(j))
				i++;
			else
				j++;
		}
		return min;
	}
}
