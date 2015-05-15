import java.util.*;

class Solution {
    private List<List<Integer>> run(int[] candidates, int target, int prev)    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = candidates.length;
        int prevVal = 0;
        for (int i = prev; i < n; i++)  {
        	if (i > prev && candidates[i] == prevVal) continue;
        	prevVal = candidates[i]; 
            if (candidates[i] == target)    {
                List<Integer> newCand = new LinkedList<Integer>();
                newCand.add(target);
                result.add(newCand);
            } else if (candidates[0] <= target - candidates[i]) {
                List<List<Integer>> tmp = run(candidates, target - candidates[i], i);
                for (List<Integer> candidate : tmp)  {
                    candidate.add(0, candidates[i]);
                    result.add(candidate);
                }
            }
        }
        return result;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	int n = candidates.length;
    	int [] num = new int[n];
    	
    	System.out.println("sorted:");
    	for (int i: candidates)
    		System.out.print(i + " ");
    	System.out.println("");
        List<List<Integer>> result = run(candidates, target, 0);
        
        return result;
    }
}

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		//int[] candidates = { 8,7,4,3};
		int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
		List<List<Integer>> result = solution.combinationSum(candidates, 27);
		
		for (List<Integer> list : result)	{
			System.out.println(list);
		}
	}

}
