class ListNode {
	int val;
 	ListNode next;
 	ListNode(int x) {
 		val = x;
 		next = null;
 	}
}
 
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
            
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode p = head;
        while (p != null)    {
            ListNode q = p.next;
            if (q == null)
                break;

            prev.next = q;
            ListNode next = q.next;
            q.next = p;
            p.next = next;
            prev = p;
            p = next;
        }
        
        return dummy.next;
    }
}

public class SwapNodesInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
