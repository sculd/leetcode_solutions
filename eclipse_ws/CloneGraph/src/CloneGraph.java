/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        
        boolean ifFirst = true;
        UndirectedGraphNode firstCopied = null;
        while (!queue.isEmpty())    {
            node = queue.remove();
            
            UndirectedGraphNode copied = map.get(node.label);
            if (copied == null) {
                copied = new UndirectedGraphNode(node.label);
                map.put(node.label, copied);
            }
            
            if (ifFirst)    {
                firstCopied = copied;
                ifFirst = false;
            }
            
            for (UndirectedGraphNode cNode: node.neighbors) {
                UndirectedGraphNode copiedChild = map.get(cNode.label);
                
                if (copiedChild == null) {
                    queue.add(cNode);
                    copiedChild = new UndirectedGraphNode(cNode.label);
                    map.put(cNode.label, copiedChild);
                }
                
                copied.neighbors.add(copiedChild);
            }
        }
        
        return firstCopied;
    }
}

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
