import java.util.*;

class Solution {
    public List<List<Integer>> run(int[] num, int target, int start) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = num.length;
        if (n == 0) return result;
        
        for (int i = start; i < n; i++)  {
            if (num[i] > target) break;
            // if it can be found with num[i] included, it should already be counted with num[i-1] included
        	if (i > start && num[i] == num[i-1]) continue;
            if (num[i] == target)   {
                List<Integer> newL = new LinkedList<Integer>();
                newL.add(num[i]);
                result.add(newL);
            } else {
                List<List<Integer>> tmp = run(num, target - num[i], i+1);
                for (List<Integer> l: tmp)  {
                    l.add(0, num[i]);
                    result.add(l);
                }
            }
        }

        return result;
    }
    
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        return run(num, target, 0);
    }
}

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
