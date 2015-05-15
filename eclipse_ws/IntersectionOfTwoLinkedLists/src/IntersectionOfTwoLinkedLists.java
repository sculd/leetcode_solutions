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
 
class SolutionWithConstSpace {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // count the number of nodes
        int n = 0;
        ListNode nodeA = headA;
        while (nodeA != null)   {
            n += 1;
            nodeA = nodeA.next;
        }
        
        int m = 0;
        ListNode nodeB = headB;
        while (nodeB != null)   {
            m += 1;
            nodeB = nodeB.next;
        }

        // A is the shorter one
        if (n > m)  {
            ListNode temp = headB;
            headB = headA;
            headA = temp;
            int t = m;
            m = n;
            n = t;
        }
        
        // step in B so we have the same number of nodes left for A and B.
        for (int i = 0; i < m - n; i++) {
            headB = headB.next;
        }
        
        
        while (true)    {
            if (headA == headB)
                return headA;
            
            headA = headA.next;
            headB = headB.next;
            if (headA == null)
                break;
        }
        
        return null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<ListNode>();
        Stack<ListNode> stackB = new Stack<ListNode>();
        
        while (headA != null)   {
            stackA.push(headA);
            headA = headA.next;
        }
        
        while (headB != null)   {
            stackB.push(headB);
            headB = headB.next;
        }
        
        ListNode common = null;
        
        while (true)    {
            if (stackA.empty() || stackB.empty())
                break;
            ListNode nodeA = stackA.pop();
            ListNode nodeB = stackB.pop();
            
            if (nodeA != nodeB)
                break;
                
            common = nodeA;
        }
        
        return common;
    }
}

public class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
