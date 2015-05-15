import java.util.*;

class Solution {
    private void run(List<List<Integer>> result, int[] list, int n, int k, int pos) {
        for (int i = 1; i <= n; i++)    {
            if (pos == 0)   {
                list[pos] = i;
            } else {
                // the number should be larger than previous one to avoid the duplication
                if (list[pos-1] < i)
                    list[pos] = i;
                else 
                    continue;
            }

            if (pos == k - 1)    {
                // reach the last pos
                List<Integer> newR = new ArrayList<Integer>();
                for (int p = 0; p < k; p++)
                    newR.add(list[p]);
                result.add(newR);
            } else {
                run(result, list, n, k, pos+1);
            }
        }    
    }
    
    public List<List<Integer>> combine(int n, int k) {
        int[] list = new int[n];
        for (int i = 1; i <= n; i++) {
            list[i-1] = i;
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        run(result, list, n, k, 0);
        
        return result;
    }
}

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
