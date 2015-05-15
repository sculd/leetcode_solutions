import java.io.*;
import java.util.*;

class TreeNode {
	int val;
	List<TreeNode> links;
	TreeNode(int x) { 
		val = x; 
		links = new ArrayList<TreeNode>();
	}
}

public class FullBinaryTree {
	static Map<Integer, Map<Integer, Integer>> nDestroyedNodes = new HashMap<Integer, Map<Integer, Integer>>();
	static int getNumDescendents(TreeNode node, TreeNode parent)	{
		int result = 1; // include node
		for (TreeNode child: node.links)	{
			if (child == parent)	continue;
			result += getNumDescendents(child, node);
		}
		return result;
	}
	
	static int travel(TreeNode node, TreeNode parent)	{
		Map<Integer, Integer> tmpMap = nDestroyedNodes.get(node.val);
		if (tmpMap == null)
			tmpMap = new HashMap<Integer, Integer>();
		
		if (parent != null)	{
			Integer nDestroyed = tmpMap.get(parent.val);
			// if the value had been already calculated
			if (nDestroyed != null)
				return nDestroyed;
		}
		
		int result = 0;
		int nChildren = node.links.size();
		if (parent != null)	nChildren--;
		
		if (nChildren == 2)	{
			// we don't have to cut any children of this node
			for (TreeNode child: node.links)	{
				if (child == parent)	continue;
				// but potentially, we might have to cut some descendants
				result += travel(child, node);
			}
		} else if (nChildren == 1)	{
			// we have to cut all the descendants of the only child TT
			for (TreeNode child: node.links)	{
				if (child == parent)	continue;
				result += getNumDescendents(child, node);
			}
		} else if (nChildren > 2) {
			// for each pair, count the # of descendants of the reminders
			int minTmp = Integer.MAX_VALUE;
			for (TreeNode child1: node.links)	{
				if (child1 == parent)	continue;
				for (TreeNode child2: node.links)	{
					if (child2 == parent)	continue;
					int deleted = 0;
					for (TreeNode child: node.links)	{
						if (child == child1 || child == child2 || child == parent)	continue;
						deleted += getNumDescendents(child, node);
					}
					minTmp = Math.min(deleted, minTmp);
				}
			}
			
			int min = Integer.MAX_VALUE;
			// in case of the tie
			for (TreeNode child1: node.links)	{
				if (child1 == parent)	continue;
				for (TreeNode child2: node.links)	{
					if (child2 == parent)	continue;
					int deleted = 0;
					for (TreeNode child: node.links)	{
						if (child == child1 || child == child2 || child == parent)	continue;
						deleted += getNumDescendents(child, node);
					}
					
					if (deleted == minTmp)	{
						int potentiallyDeleted = 0;
						for (TreeNode child: node.links)	{
							if (child != child1 && child != child2)	continue;
							potentiallyDeleted += travel(child, node);
						}
						min = Math.min(min, potentiallyDeleted);
					}
				}
			}
			result = min;
		} else {
			// no children other than parent
			result = 0;
		}
		
		if (parent != null)
			tmpMap.put(parent.val, result);
		return result;
	}
	
	static void solve(String ifName, String ofName)	{
		try	{
			File f = new File(ifName);
			if (!f.exists())
				System.out.println(ifName + " not exist!");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			PrintWriter writer = new PrintWriter(ofName);
			
			int T = Integer.valueOf(reader.readLine());
			
			for (int t = 0; t < T; t++)	{
				// for each test case
				int N = Integer.valueOf(reader.readLine());
				
				// create N nodes
				List<TreeNode> nodes = new ArrayList<TreeNode>();
				for (int n = 0; n < N; n++)	{
					nodes.add(new TreeNode(n));
				}
				
				// create the edge
				for (int e = 0; e < N-1; e++)	{
					// for each edge
					String line = reader.readLine();
					String[] pair = line.split("\\s+");
					TreeNode node1 = nodes.get(Integer.valueOf(pair[0]) - 1);
					TreeNode node2 = nodes.get(Integer.valueOf(pair[1]) - 1);
					node1.links.add(node2);
					node2.links.add(node1);
				}
				
				// pick the one with the minimum removal
				int minRemoval = Integer.MAX_VALUE;
				for (TreeNode node: nodes)	{
					int nRemoval = travel(node, null);
					minRemoval = Math.min(minRemoval, nRemoval);
				}
				
				String outStr = "Case #" + (t+1) + ": " + minRemoval + "\n";
				writer.print(outStr);
			}
			reader.close();
			writer.close();
			System.out.println("complete");
	    } catch (IOException e)	{
	        System.out.println("File I/O error!");
	    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve("B-tiny-practice.in", "output-tiny.txt");
		solve("B-small-practice.in", "output-small.txt");
		solve("B-large-practice.in", "output-large.txt");
	}
}
