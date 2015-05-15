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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int cur = 1;
        int next = 0;
        int minDepth = 1;
        while (!queue.isEmpty())    {
            TreeNode node = queue.remove();
            cur--;
            
            if (node.left != null)  {
                queue.add(node.left);
                next++;
            }
            
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            
            if (node.left == null && node.right == null)
                break;
            
            if (cur == 0)   {
                cur = next;
                next = 0;
                minDepth++;
            }
        }
        
        return minDepth;
    }
}

public class MinimumDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
