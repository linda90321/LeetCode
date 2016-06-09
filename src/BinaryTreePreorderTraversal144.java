/*Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

Subscribe to see which companies asked this question

Hide Tags Tree Stack
Hide Similar Problems (M) Binary Tree Inorder Traversal (M) Verify Preorder Sequence in Binary Search Tree
*/

import java.util.*;
public class BinaryTreePreorderTraversal144 {
	/*
    //Divide & Conquer
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
        return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        
        return res;
    }
    */
    /*
    //traverse
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root,res);
        return res;
    }
    
    public void traverse(TreeNode root, List<Integer> res){
        if(root == null)
        return;
        res.add(root.val);
        traverse(root.left, res);
        traverse(root.right, res);
    }
    */
    //Non-Recursion
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
         return res;
         
         Stack<TreeNode> stack = new Stack<TreeNode>();
         
         while(!stack.isEmpty() || root != null){
             if(root != null){
                 stack.push(root);
                 res.add(root.val);
                 root = root.left;
             }else{
                 TreeNode last = stack.pop();
                 root = last.right;
             }
         }
         
         return res;
    }
    
}
