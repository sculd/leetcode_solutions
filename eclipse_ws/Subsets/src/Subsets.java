import java.util.*;

class Solution {
    private List<List<Integer>> addSubsets(List<List<Integer>> soFar, int[] S, int lastAdded) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = S.length;
        if (lastAdded == n - 1) return result;
        
        for (int i = lastAdded + 1; i < n; i++)   {
        	List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            // add one more member
            for(List<Integer> list: soFar)  {
                List<Integer> newList = new ArrayList<Integer>();
                for (int v: list) newList.add(v);
                newList.add(S[i]);
                newResult.add(newList);
            }
            
            // recursive call
            List<List<Integer>> tmp = addSubsets(newResult, S, i);
            for(List<Integer> list: tmp)  
            	newResult.add(list);
            	
            // add to result
            for(List<Integer> list: newResult)  
               	result.add(list);
        }
        return result;
    }
    
    public List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S);
        List<List<Integer>> emptySet = new ArrayList<List<Integer>>();
        emptySet.add(new ArrayList<Integer>());
        List<List<Integer>> result = addSubsets(emptySet, S, -1);
        result.addAll(emptySet);
        return result;
    }
}

public class Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		//int[] S = {1,9,8,3,-1,0};		
		int[] S = {3,2,1};
		List<List<Integer>> result = solution.subsets(S);
		for (List<Integer> list: result)
			System.out.println(list);
	}

}
