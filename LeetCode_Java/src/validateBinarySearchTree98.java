class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class validateBinarySearchTree98 {
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if (max != null && root.val >= max)
			return false;

		if (min != null && root.val <= min)
			return false;

		if (helper(root.left, min, root.val)
				&& helper(root.right, root.val, max))
			return true;

		return false;
	}
}