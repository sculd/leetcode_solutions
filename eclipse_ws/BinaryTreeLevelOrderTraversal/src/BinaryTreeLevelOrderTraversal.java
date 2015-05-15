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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int cur = 1;
        int next = 0;
        List<Integer> list = new ArrayList<Integer>();
        
        while (!queue.isEmpty())    {
            TreeNode node = queue.remove();
            list.add(node.val);
            cur--;
            
            if (node.left != null)  {
                queue.add(node.left);
                next++;
            }
            
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            
            if (cur == 0)   {
                result.add(list);
                list = new ArrayList<Integer>();
                cur = next;
                next = 0;
            }
        }
        
        return result;
    }
    
}
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
