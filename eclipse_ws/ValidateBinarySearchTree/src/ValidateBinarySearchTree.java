import java.util.*;

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
    TreeNode prev;
    
    private boolean visit(TreeNode root) {
        if (root == null) return true;
        
        boolean result = visit(root.left);
        if (!result) return false;
        
        if (prev != null && prev.val >= root.val)
            return false;
        prev = root;
        
        result = visit(root.right);
        if (!result) return false;
        
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return visit(root);
    }
}

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
