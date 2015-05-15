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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) 
            return head;
        ListNode node = head;
        while (true)    {
            if (node.next == null)
                break;
            if (node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return head;
    }
}

public class RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
