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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int cur = 1;
        int next = 0;
        boolean ifReverseRow = false;
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
                if (ifReverseRow)   {
                    List<Integer> reversed = new ArrayList<Integer>();
                    int n = list.size();
                    for (int i = n-1; i >= 0; i--)  {
                        reversed.add(list.get(i));
                    }
                    result.add(reversed);
                } else {
                    result.add(list);
                }
                list = new ArrayList<Integer>();
                
                ifReverseRow = !ifReverseRow;
                cur = next;
                next = 0;
            }
        }
        
        return result;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
