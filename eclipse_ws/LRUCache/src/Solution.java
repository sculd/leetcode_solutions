import java.util.*;

class LRUCache {
    private class Node    {
        public int key, val;
        public Node prev, next;
        public Node(int key, int val)    {
            this.key = key;
            this.val = val;
        }
    }
    
    private int capacity;
    private int num;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node dummy = new Node(0, 0);
    private Node tail = dummy;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.num = 0;
    }
    
    private void removeNodeFromList(Node node)   {
        this.LinkNodes(node.prev, node.next);
        if (node == this.tail)
            this.tail = node.prev;
    }
    
    private void LinkNodes(Node prev, Node next)  {
        if (prev != null)  {
            prev.next = next;
        }
        
        if (next != null) {
            next.prev = prev;
        }
    }
    
    private void insertNodeToList(Node node)   {
        Node tmp = this.dummy.next;
        this.LinkNodes(this.dummy, node);
        this.LinkNodes(node, tmp);
        
        if (this.dummy == this.tail)
            this.tail = node;
    }

    public int get(int key) {
        Node node = this.map.get(key);
        if (node == null)
            return -1;
        else {
            // move the node to the front
            this.removeNodeFromList(node);
            this.insertNodeToList(node);
    
            return node.val;
        }
    }
    
    public void set(int key, int value) {
        Node node = this.map.get(key);
        if (node != null)   {
            node.val = value;
            // remove the node
            this.removeNodeFromList(node);
        } else {
            this.num++;
            node = new Node(key, value);
            this.map.put(key, node);
        }
        
        // place the node at the front
        this.insertNodeToList(node);
        
        // keep it inside the capacity
        if (this.num == this.capacity + 1)    {
            this.map.remove(this.tail.key);
            this.tail = this.tail.prev;
            this.LinkNodes(this.tail, null);            
            this.num--;
        }
    }
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
