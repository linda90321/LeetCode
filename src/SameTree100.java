/*Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Hide Company Tags Bloomberg
Hide Tags Tree Depth-first Search
 */
public class SameTree100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q != null)
			return false;

		if (p != null && q == null)
			return false;

		if (p == null && q == null)
			return true;

		return p.val == q.val && isSameTree(p.left, q.left)
				&& isSameTree(p.right, q.right);
	}
}
