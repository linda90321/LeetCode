package indeedPrime;

import java.util.LinkedList;
import java.util.Queue;

/*给定一个Tree, 如何存储这个树来节省空间？

Solution:
Use a binary heap to represent a complete binary tree.

Complete tree: perfectly balanced tree, except for the bottom level. 
Binary heap: Array representation of a heap-ordered complete binary tree. */
public class TreeToArray {
    private Queue<TreeNode> nodeQueue = new LinkedList<>();
    private Queue<Integer> indexQueue = new LinkedList<>();
    public Integer[] compressTree(TreeNode root) {
        // step 1: get the height of the tree
        int height = getTreeHeight(root);
        int n = (int) Math.pow(2, height);
        Integer[] array = new Integer[n];
         
        nodeQueue.offer(root);
        indexQueue.offer(1);
         
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int index = indexQueue.poll();
             
            array[index] = node.val;
             
            if (node.left != null) {
                nodeQueue.offer(node.left);
                indexQueue.offer(2 * index);
            }
             
            if (node.right != null) {
                nodeQueue.offer(node.right);
                indexQueue.offer(2 * index + 1);
            }
        }
         
        return array;
    }
     
    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);
         
        return Math.max(left, right) + 1;
    }
     
    public static void main(String[] args) throws InterruptedException {
    	TreeToArray sol = new TreeToArray();
         
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
         
        Integer[] result = sol.compressTree(root);
         
        for (Integer e : result) {
            System.out.print(e + " ");
        }
         
        System.out.println("");
    }
     
     

}
class TreeNode {
        int val;
        TreeNode left, right;
         
        public TreeNode (int val) {
            this.val = val;
        }
    }