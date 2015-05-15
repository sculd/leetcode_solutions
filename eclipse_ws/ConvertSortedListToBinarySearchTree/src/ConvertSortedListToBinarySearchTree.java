import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; next = null; }
 }

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
 }

class Solution {
    private TreeNode sortedArrayToBST(ListNode[] nodes, int begin, int end) {
        if (end - begin <= 0) return null;
        
        int r = (begin + end) / 2;
        TreeNode root = new TreeNode(nodes[r].val);

        TreeNode left = sortedArrayToBST(nodes, begin, r);
        TreeNode right = sortedArrayToBST(nodes, r + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null)    {
            node = node.next;
            n++;
        }
        
        ListNode [] nodes = new ListNode[n];
        int i = 0;
        node = head;
        while (node != null)    {
            nodes[i] = node;
            i++;
            node = node.next;
        }
        
        return sortedArrayToBST(nodes, 0, n);
    }
}

public class ConvertSortedListToBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
