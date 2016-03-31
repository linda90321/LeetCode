import java.util.LinkedList;
import java.util.Queue;

/*Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
Hide Tags Tree
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class InvertBinaryTree226 {
	/*
	 * public TreeNode invertTree(TreeNode root) { if (root == null) return
	 * null;
	 * 
	 * TreeNode left = root.left; TreeNode right = root.right;
	 * 
	 * root.left = right; root.right = left;
	 * 
	 * invertTree(left); invertTree(right);
	 * 
	 * return root; }
	 */

	// iteration BFS
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();

			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);

			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
		}
		return root;

	}
}
