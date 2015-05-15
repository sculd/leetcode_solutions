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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        
        ListNode prevM = null;
        ListNode M = head;
        
        int i = 1;
        while (true)    {
            if (i == m) break;
            if (i < m)  {   
                prevM = M;
                M = M.next; 
            }
            i++;
        }

        ListNode node = M;
        ListNode node2 = M.next;
        while (true)    {
            if (i < n)  {
                ListNode nextNode2 = node2.next;
                node2.next = node;
                node = node2;
                node2 = nextNode2; 
            }
            if (i == n) break;
            i++;
        }
        
        if (prevM != null)  {
            prevM.next = node;
        } else {
            head = node;
        }
        M.next = node2;

        return head;
    }
}

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
