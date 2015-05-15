class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
    private TreeNode sortedArrayToBST(int[] num, int head, int tail) {
        if (head >= tail)
            return null;
        
        int m = (head + tail) / 2;
        TreeNode node = new TreeNode(num[m]);
        node.left = sortedArrayToBST(num, head, m);
        node.right = sortedArrayToBST(num, m + 1, tail);
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }
}

public class ConvertSortedArrayToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
