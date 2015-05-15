import java.util.*;

class TreeNode {
	int val;
 	TreeNode left;
 	TreeNode right;
 	TreeNode(int x) { val = x; }
}
 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<Integer>();
        
        if (root == null)
            return l;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.empty())  {
            TreeNode node = stack.pop();
            l.add(node.val);
            
            if (node.right != null)
                stack.push(node.right);
            
            if (node.left != null)
                stack.push(node.left);
        }
        
        return l;
    }
}

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
