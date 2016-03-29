package indeedPrime;

// For your reference
class Node {
		Node left, right;
		int data;
                Node(int newData) {
			left = right = null;
			data = newData;
		}
	}


public class test1 {

	private static int isPresent(Node root, int val){

		    
		    if (root==null) return 0;
			if (root.data==val) return 1;    
			return (isPresent(root.left, val)==1||isPresent(root.right, val)==1)? 1: 0;
		}

}
