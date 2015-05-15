/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    private int visit(TreeNode root) {
        if (root == null)   {
            return 0;
        }
        
        int lVisit = visit(root.left);
        int rVisit = visit(root.right);
        
        if (lVisit == -1 || rVisit == -1 || Math.abs(lVisit - rVisit) > 1)
            return -1;
        
        return Math.max(lVisit, rVisit) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        return visit(root) > -1;
    }
}

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
