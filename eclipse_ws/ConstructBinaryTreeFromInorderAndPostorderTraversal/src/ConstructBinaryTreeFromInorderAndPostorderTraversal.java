import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    private TreeNode buildTree(int[] inorder, int[] postorder, int is, int ie, int ps, int pe, Map<Integer, Integer> inorderPos)
    {
        if (ps >= pe)
            return null;

        int val = postorder[pe-1];
        TreeNode node = new TreeNode(val);
        int m = inorderPos.get(val);
        int lLen = m - is;
        node.left = buildTree(inorder, postorder, is, m, ps, ps + lLen, inorderPos);
        node.right = buildTree(inorder, postorder, m + 1, ie, ps + lLen, pe - 1, inorderPos);
        
        return node;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderPos = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            inorderPos.put(inorder[i], i);
            
        return buildTree(inorder, postorder, 0, inorder.length, 0, inorder.length, inorderPos);
    }
}

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
