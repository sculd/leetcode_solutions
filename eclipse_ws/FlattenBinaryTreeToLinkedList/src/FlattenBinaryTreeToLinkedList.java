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

class Solution_bkup {
    private void connect(TreeNode former, TreeNode latter) {
        if (former != null)
            former.right = latter;
            
        if (latter != null)
            latter.left = former;
    }
    
    private TreeNode visit(TreeNode node)   {
        if (node.left == null && node.right == null)    {
            connect(node, node);
            return node;
        }
        
        TreeNode last = node;
        
        TreeNode right = node.right;
        if (node.left != null)  {
            last = visit(node.left);
            connect(node, last.right);
        }
        
        if (right != null)  {
            TreeNode tmp = last;
            last = visit(right);
            connect(tmp, last.right);
        }
        
        connect(last, node);
        
        return last;
    }
    
    public void flatten(TreeNode root) {
        if (root != null)   {
            TreeNode last = visit(root);
            connect(null, last.right);
            connect(last, null);
        }
    }
}

class Solution_connect {
    void bridge(TreeNode node1, TreeNode node2)   {
        if (node1 != null)
            node1.right = node2;
            
        if (node2 != null)
            node2.left = node1;
    }
    
    void connect(TreeNode loop1, TreeNode loop2)    {
        if (loop1 == null || loop2 == null)
            return;
        
        // bridge loop1 <-> loop2
        TreeNode last = loop2.left;
        bridge(loop1.left, loop2);

        // bridge <- loop1, loop2 ->
        bridge(last, loop1);
    }
    
    void loop(TreeNode root) {
    	if (root == null)
    		return;
        // flatten the root, but wire the first and the last in the cirular way.
    	TreeNode left = root.left;
    	TreeNode right = root.right;
        loop(left);
        loop(right);
        bridge(root, root);
        
        connect(root, left);
        connect(root, right);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
            
        loop(root);
        bridge(root.left, null);
        bridge(null, root);
    }
}


class Solution_pre_recursive {
    TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode right = root.right;
        TreeNode left = root.left;
        root.right = root.left;
        root.left = null;
        if (prev != null)
            prev.right = root;
        
        prev = root;

        flatten(left);
        flatten(right);
    }
}

public class FlattenBinaryTreeToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		
		Solution_pre_recursive solution = new Solution_pre_recursive();
		solution.flatten(node1);
		
		System.out.println("done");
	}

}
