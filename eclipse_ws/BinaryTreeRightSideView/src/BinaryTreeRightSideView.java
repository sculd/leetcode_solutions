import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        int cur = 1;
        int next = 0;
        while (!queue.isEmpty())    {
            TreeNode node = queue.remove();
            if (node.left != null)  {
                next += 1;
                queue.add(node.left);
            }
            
            if (node.right != null) {
                next += 1;
                queue.add(node.right);
            }
            
            cur -= 1;
            
            if (cur == 0)   {
                result.add(node.val);
                cur = next;
                next = 0;
            }
        }
        
        return result;
    }
}

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
