import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        int size = 0;
        ListNode node = head;
        while (node != null)    {
            node = node.next;
            size++;
        }

        if (n == size) return head.next;

        int pos = 1;        
        ListNode prev = head;
        while (pos < size - n)    {
            prev = prev.next;
            pos++;
        }
        prev.next = prev.next.next;
        
        return head;
    }
}

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode node1 = new ListNode(1);
		solution.removeNthFromEnd(node1, 1);
	}

}
