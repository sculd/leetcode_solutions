import java.util.*;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode insert = dummy;
        while (true)    {
            if (insert == null)
                break;

            ListNode prev = insert;
            ListNode node = insert.next;
            while (true)    {
                if (node == null)
                    break;
                
                if (node.val < insert.next.val) {
                    // remove
                    prev.next = node.next;
                    
                    // insert
                    ListNode tmp = insert.next;
                    insert.next = node;
                    node.next = tmp;
                }
                
                prev = node;
                node = node.next;
            }
                            
            insert = insert.next;
        }
        
        return dummy.next;
    }
}

public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
