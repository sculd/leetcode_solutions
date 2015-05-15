/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}

class Solution {
    /*
    In the inorder traversal, the swapped nodes make the traversal unsorted.
    The common denominator of the swapped nodes is either their ancestor or one of them.
    If ancestor, two pairs appear to be unsorted in the inorder traversal.
    If one of them, only one pair appears to be unsorted.
    */

    TreeNode prevNode, firstPairNode1, firstPairNode2, secondPairNode1, secondPairNode2;
    
    private void inOrder(TreeNode node) {
        if (node == null)
            return;
            
        inOrder(node.left);
        
        // node
        if (prevNode != null && prevNode.val > node.val)   {
            if (firstPairNode1 == null) {
                firstPairNode1 = prevNode;
                firstPairNode2 = node;
            } else {
                secondPairNode1 = prevNode;
                secondPairNode2 = node;
            }
        }
        prevNode = node;
        
        inOrder(node.right);                
    }
    
    public void recoverTree(TreeNode root) {
        prevNode = null;
        firstPairNode1 = null;
        firstPairNode2 = null;
        secondPairNode1 = null;
        secondPairNode2 = null;
        
        inOrder(root);
        
        if (secondPairNode1 == null) {
           int tmp = firstPairNode1.val;
           firstPairNode1.val = firstPairNode2.val;
           firstPairNode2.val = tmp;
        } else {
           int tmp = firstPairNode1.val;
           firstPairNode1.val = secondPairNode2.val;
           secondPairNode2.val = tmp;
        }
    }
}

public class ReoverBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
