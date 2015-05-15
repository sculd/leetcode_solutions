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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (true)    {
            int sum = carry;
            
            if (sum == 0 && l1 == null && l2 == null)
                break;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode node = new ListNode(sum);
            prev.next = node;
            prev = node;
        }
        
        return dummy.next;
    }
}

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
