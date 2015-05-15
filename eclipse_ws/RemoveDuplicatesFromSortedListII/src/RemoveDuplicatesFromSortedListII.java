class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		next = null;
		val = x;
	}
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        
        ListNode dummy = new ListNode(head.val - 1);
        dummy.next = head;
        ListNode prev = dummy, node = head;

        while(true) {
            if (node == null)
                break;
            
            if (node.next != null && node.val == node.next.val)  {
                // duplicate found, remove the duplicates
                int val = node.val;
                while (true)    {
                    node = node.next;
                    if (node == null || node.val != val)
                        break;
                }
                prev.next = node;
            } else {
                // otherwise, move on
                prev = node;
                node = node.next;
            }
        }

        return dummy.next;
    }
}

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
