/*This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

Hide Company Tags LinkedIn
Hide Tags Array
Hide Similar Problems (E) Shortest Word Distance (M) Shortest Word Distance II*/

public class ShortestWordDistance_III245 {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int pos1 = -1;
		int pos2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1))
				pos1 = i;
			else if (words[i].equals(word2))
				pos2 = i;
			else
				continue;

			if (pos1 != -1 && pos2 != -1)
				min = Math.min(min, Math.abs(pos1 - pos2));

			if (word1.equals(word2) && pos1 > pos2)
				pos2 = pos1;

		}

		return min;
	}
}
