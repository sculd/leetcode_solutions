class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
 
class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        if (n == 0) return head;
        
        int len = 1;
        ListNode node = head;
        ListNode tail = node;
        while (node.next != null)    {
            node = node.next;
            tail = node;
            len++;
        }
        if (len <= 1) return head;
        
        n = n % len;
        if (n == 0) return head;

        ListNode nodek = head;
        for (int i = 0; i < n; i++)   {
            nodek = nodek.next;
        }
        
        ListNode newTail = head;
        for (int i = 0; i < len-1-n; i++)   {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}

public class RotateList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
