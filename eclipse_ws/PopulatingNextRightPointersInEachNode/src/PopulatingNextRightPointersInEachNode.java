/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

import java.util.*;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}

class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        int nCur = 1;
        int nNext = 0;
        queue.add(root);
        TreeLinkNode prevNode = null;
        
        while (!queue.isEmpty())    {
            TreeLinkNode node = queue.remove();
            nCur--;
            
            if (prevNode != null)
                prevNode.next = node;
            
            if (node.left != null)  {
                queue.add(node.left);
                nNext++;
            }
            
            if (node.right != null) {
                queue.add(node.right);
                nNext++;
            }
            
            prevNode = node;
            if (nCur == 0)  {
                nCur = nNext;
                nNext = 0;
                node.next = null;
                prevNode = null;
            }
        }
    }
}

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
