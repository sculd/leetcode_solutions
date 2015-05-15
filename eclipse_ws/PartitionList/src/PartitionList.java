
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
    private ListNode insertNode(ListNode head, ListNode insert, ListNode prev, ListNode node) {
        if (head == node) return head;
        if (insert != null && node == insert.next) return head;
        ListNode next = node.next;
	        
        if (insert == null) {
            // insert at head
            node.next = head;
            head = node;
        } else if (node != insert.next) {
            ListNode tmp = insert.next;
            insert.next = node;
            node.next = tmp;
        } 
	        
        if (prev != null)
            prev.next = next;

        return head;
    }
	    
    public ListNode partition(ListNode head, int x) {
    	if (head == null) return null;
	        
        ListNode insert = null;
        ListNode cur = head;
        ListNode prev = null;
	        
        while (true)    {
        	if (cur.val < x)    {
                head = insertNode(head, insert, prev, cur);
                insert = cur;
            }
            prev = cur;
            cur = cur.next;
            if (cur == null) break;
        }
	        
        return head;
    }
}

public class PartitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		node1.next = node2;
		solution.partition(node1, 2);
	}

}
