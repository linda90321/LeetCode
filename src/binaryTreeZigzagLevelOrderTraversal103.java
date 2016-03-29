import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]*/
public class binaryTreeZigzagLevelOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean flag = false;
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode top = queue.poll();
				temp.add(top.val);

				if (top.left != null) {
					queue.add(top.left);
				}
				if (top.right != null) {
					queue.add(top.right);
				}

			}
			if (!flag) {
				flag = true;
				res.add(temp);
			} else {
				Collections.reverse(temp);
				res.add(temp);
				flag = false;
			}

		}

		return res;
	}
}
