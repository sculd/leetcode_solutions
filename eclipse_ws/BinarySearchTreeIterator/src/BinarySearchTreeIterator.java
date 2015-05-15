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

class BSTIterator {
    Stack<TreeNode> stack;
    
    private void addToStack(TreeNode root)  {
        if (root == null)
            return;
        stack.push(root);
        this.addToStack(root.left);
    }
    
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.addToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        this.addToStack(node.right);
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class BinarySearchTreeIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
