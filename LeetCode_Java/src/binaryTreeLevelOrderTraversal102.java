import java.util.*;

/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]*/
public class binaryTreeLevelOrderTraversal102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

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

			res.add(temp);

		}

		return res;
	}
}
