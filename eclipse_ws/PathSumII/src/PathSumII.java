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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        if (root.left != null)  {
            List<List<Integer>> tmp = pathSum(root.left, sum - root.val);
            for(List<Integer> list: tmp) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        if (root.right != null)  {
            List<List<Integer>> tmp = pathSum(root.right, sum - root.val);
            for(List<Integer> list: tmp) {
                list.add(0, root.val);
                result.add(list);
            }
        }
        
        // terminal node
        if (root.left == null & root.right == null) {
            if (sum == root.val)    {
                List<Integer> list = new ArrayList<Integer>();
                list.add(root.val);
                result.add(list);
            }
        }

        return result;
    }
}

public class PathSumII {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		node1.left = node2;
		
		Solution solution = new Solution();
	    List<List<Integer>> result = solution.pathSum(node1, 3);
	    for (List<Integer> list: result)
	    	System.out.println(list);
	}

}
