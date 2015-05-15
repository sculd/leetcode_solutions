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

public class FacebookBinaryTreeToDoubleLinkedList {
	static private TreeNode convertAndGetTheLast(TreeNode node){
		TreeNode first = null;
		TreeNode last = null;
		
		if (node.left == null && node.right == null){
			first = node;
			last = node;
		} else if (node.left == null)	{
			first = node;
			last = convertAndGetTheLast(node.right);
			last.right.left = node;
			node.right = last.right;
		} else if (node.right == null)	{
			TreeNode leftLast = convertAndGetTheLast(node.left);
			last = node;
			first = leftLast.right;
			leftLast.right = node;
			node.left = leftLast;
		} else {
			TreeNode leftLast = convertAndGetTheLast(node.left);
			first = leftLast.right;
			leftLast.right = node;
			node.left = leftLast;
			
			last = convertAndGetTheLast(node.right);
			last.right.left = node;
			node.right = last.right;
		}
		
		
		last.right = first;
		first.left = last;
		
		return last;
	}
	
	static private void bTreeToList(TreeNode root){
		convertAndGetTheLast(root);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
