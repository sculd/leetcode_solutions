import java.util.*;

class Solution {
    public int minimumTotal_optimal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0)
            return 0;
        
        int []mins = new int[n];
        for (int i = 0; i < n; i++)
            mins[i] = triangle.get(n-1).get(i);

        for (int r = n - 2; r >= 0; r--)    {
            List<Integer> row = triangle.get(r);
            for (int i = 0; i <= r; i++) {
                mins[i] = triangle.get(r).get(i) + Math.min(mins[i], mins[i+1]);
            }
        }
        
        return mins[0];
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) return 0;
        
        int []results = new int[n];
        int []tmp = new int[n];
        
        // the last row
        for (int i = 0; i < n; i++)
            results[i] = triangle.get(n-1).get(i);
        
        // for each row from the second last one
        for (int r = n-2; r >= 0; r--)  {
            // copy the current result to the tmp
            for (int i = 0; i <= r+1; i++)
                tmp[i] = results[i];
            
            // for each element, update the minimum value
            List<Integer> row = triangle.get(r);
            for (int i = 0; i <= r; i++)
                tmp[i] = Math.min(results[i], results[i+1]) + row.get(i);
                
            // update the results
            for (int i = 0; i <= r; i++)
                results[i] = tmp[i];
        }
        
        return results[0];
    }
}

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
