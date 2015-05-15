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
    int maxPathSumValue;
    
    private int recursive(TreeNode root)   {
        if (root == null) return 0;

        int result = 0;
        int leftVal = recursive(root.left);
        int rightVal = recursive(root.right);
        if (leftVal > rightVal) {
            if (leftVal > 0)
                result = leftVal + root.val;
            else
                result = root.val;
        } else {
            if (rightVal > 0)
                result = rightVal + root.val;
            else
                result = root.val;
        }
        
        int rootMaxSum = root.val;
        if (leftVal > 0) 
            rootMaxSum += leftVal;
        if (rightVal > 0) 
            rootMaxSum += rightVal;
        
        if (rootMaxSum > maxPathSumValue)
            maxPathSumValue = rootMaxSum;
        
        return result;
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSumValue = Integer.MIN_VALUE;
        recursive(root);
        return maxPathSumValue;
    }
}

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
