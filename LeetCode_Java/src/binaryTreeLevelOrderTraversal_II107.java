import java.util.*;

/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]*/
public class binaryTreeLevelOrderTraversal_II107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

			res.add(0, temp);

		}

		return res;
	}
}
