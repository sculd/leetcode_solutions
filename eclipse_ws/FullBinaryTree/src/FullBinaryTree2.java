import java.io.*;
import java.util.*;

public class FullBinaryTree2 {
	static Map<Integer, Map<Integer, Integer>> fullTreeSizes = new HashMap<Integer, Map<Integer, Integer>>();
	
	static int travel(TreeNode node, TreeNode parent)	{
		Map<Integer, Integer> tmpMap = fullTreeSizes.get(node.val);
		if (tmpMap == null)
			tmpMap = new HashMap<Integer, Integer>();
		
		if (parent != null)	{
			Integer treeSize = tmpMap.get(parent.val);
			// if the value had been already calculated
			if (treeSize != null)
				return treeSize;
		}
		
		int result = 0;
		int nChildren = node.links.size();
		if (parent != null)	nChildren--;
		
		if (nChildren <= 1)	{
			result = 1;
		} else {
			// for each pair, count the # of descendants of the reminders
			int subtreeSizes[] = new int[node.links.size()];
			for (int i = 0; i < node.links.size(); i++)	{
				TreeNode child = node.links.get(i);
				if (child == parent)	
					subtreeSizes[i] = Integer.MIN_VALUE;
				else
					subtreeSizes[i] = travel(child, node);
			}
			
			Arrays.sort(subtreeSizes);
			result = 1 + subtreeSizes[node.links.size()-1] + subtreeSizes[node.links.size()-2]; 
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
				for (int n = 1; n <= N; n++)	{
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
				
				// pick the one with the largest full tree size
				int maxFullTree = Integer.MIN_VALUE;
				for (TreeNode node: nodes)	{
					int fulltreeSize = travel(node, null);
					maxFullTree = Math.max(maxFullTree, fulltreeSize);
				}
				
				String outStr = "Case #" + (t+1) + ": " + (N - maxFullTree) + "\n";
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
