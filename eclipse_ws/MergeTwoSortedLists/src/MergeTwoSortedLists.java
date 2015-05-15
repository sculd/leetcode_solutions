class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
 	}
 }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
            
        ListNode head = null;
        ListNode append = null;
        ListNode hold = null;
        ListNode appendTo = null;
        if (l2.val > l1.val)    {
            append = l1;
            hold = l2;
            head = l1;
        }   else    {
            append = l2;
            hold = l1;
            head = l2;
        }
        
        while(true) {
            if (append == null && hold == null)
                break;
                
            else if (append == null || hold != null && append.val > hold.val)    {
                ListNode temp = append;
                append = hold;
                hold = temp;
            }

            while (true)    {
                if (append == null)
                    break;
                if (hold != null && append.val > hold.val)
                    break;
                if (appendTo != null)   
                    appendTo.next = append;
                appendTo = append;
                append = append.next;
            }
        }
        
        return head;
    }
}

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
