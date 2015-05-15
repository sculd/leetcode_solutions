import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    private TreeNode buildTree(int[]preorder, int[] inorder, int ps, int pe, int is, int ie, Map<Integer, Integer> inorderPos) {
        if (ps >= pe)   return null;
        
        TreeNode root = new TreeNode(preorder[ps]);
        int m = inorderPos.get(preorder[ps]);
        int lLen = (ps >= preorder.length - 1)? 0 : m - is;
        
        root.left = buildTree(preorder, inorder, ps + 1, ps + 1 + lLen, is, is + lLen, inorderPos);
        root.right = buildTree(preorder, inorder, ps + 1 + lLen, pe, is + lLen + 1, ie, inorderPos);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderPos = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inorderPos.put(inorder[i], i);
        
        return buildTree(preorder, inorder, 0, preorder.length, 0, preorder.length, inorderPos);
    }
}

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1, 2, 3};
		int[] inorder = {1, 2, 3};
		Solution solution = new Solution();
		TreeNode node = solution.buildTree(preorder, inorder);
		if (node != null)
			System.out.println(node.val);
	}

}
