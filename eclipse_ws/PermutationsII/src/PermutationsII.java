import java.util.*;

class Solution {
    public void permuteUnique(int[] num, int pos, List<List<Integer>> result) {
        if (pos == num.length-1)    {
            List<Integer> r = new ArrayList<Integer>();
            for(int val: num)
                r.add(val);
            result.add(r);
            
            return;
        }
        
        for (int i = pos; i < num.length; i++)  {
            if (i > pos && num[i] == num[i-1])
                continue;
            
            // swap pos and i
            int tmp = num[pos];
            num[pos] = num[i];
            num[i] = tmp;
            Arrays.sort(num, pos+1, num.length);
            
            permuteUnique(num, pos + 1, result);
            
            // recover
            tmp = num[pos];
            num[pos] = num[i];
            num[i] = tmp;
            Arrays.sort(num, pos+1, num.length);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (num.length == 0)
            return result;
        Arrays.sort(num);
        permuteUnique(num, 0, result);
        return result;
    }
}

public class PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,0,1,2,2};
		Solution solution = new Solution();
		List<List<Integer>> result = solution.permuteUnique(num);
		for (List<Integer> r: result)	{
			for (int v: r)
				System.out.print(v);
			
			System.out.println("");
		}
	}

}
