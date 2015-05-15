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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        
        if (p == null && q != null)
            return false;
        else if (p != null && q == null)
            return false;
        else if (p == null && q == null)
            return true;
            
        queue1.add(p);
        queue2.add(q);
        
        while (true)    {
            if (queue1.isEmpty())   {
                if (queue2.isEmpty())
                    break;
                else
                    return false;
            }
            else if (queue2.isEmpty())
                return false;
                
            TreeNode node1 = queue1.remove();
            TreeNode node2 = queue2.remove();
            
            if (node1.val != node2.val)
                return false;
            
            if (node1.left != null) {
                if (node2.left == null || node1.left.val != node2.left.val)
                    return false;
                queue1.add(node1.left);
                queue2.add(node2.left);
            }
            else if (node2.left != null)
                return false;
                
            if (node1.right != null) {
                if (node2.right == null || node1.right.val != node2.right.val)
                    return false;
                queue1.add(node1.right);
                queue2.add(node2.right);
            }
            else if (node2.right != null)
                return false;
            
        }
        // against all the odds...
        return true;
    }
}

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
