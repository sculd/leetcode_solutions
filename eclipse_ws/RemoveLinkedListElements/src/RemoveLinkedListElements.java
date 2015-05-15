class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(val - 1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode node = head;
        while (node != null)    {
            ListNode next = node.next;
            if (node.val == val)    {
                prev.next = next;
            } else {
                prev = node;
            }
            node = next;
        }
        
        return dummy.next;
    }
}

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
