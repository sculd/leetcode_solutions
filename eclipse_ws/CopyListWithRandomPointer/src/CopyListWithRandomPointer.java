//	Definition for singly-linked list with a random pointer.
import java.util.*;

class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}
 
class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode result = null;
        RandomListNode prev = null;
        RandomListNode prevCopied = null;
        
        // use the hashmap to store the copied nodes 
        Map <RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (head != null)    {
            RandomListNode copied = map.get(head);
            if (copied == null) {
                copied = new RandomListNode(head.label);
                map.put(head, copied);
            }
            
            if (head.random != null)    {
                RandomListNode copiedRandom = map.get(head.random);
                if (copiedRandom == null)   {
                    copiedRandom = new RandomListNode(head.random.label);
                    map.put(head.random, copiedRandom);
                }
                copied.random = copiedRandom;
            }
            
            if (prev == null)
                result = copied;
            else
                prevCopied.next = copied;

            prev = head;
            prevCopied = copied;
            head = head.next;
        }
        
        return result;
    }
}

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
