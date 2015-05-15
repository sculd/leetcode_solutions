import java.util.*;

class Solution {
    public int jump(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        
        // results[i]: # of jumps to get to i
        int [] results = new int[n];
        results[0] = 0;
        
        // update each destination
        for (int d = 1; d < n; d++) {
            results[d] = Integer.MAX_VALUE;
            
            // can begin from the beginning
            for (int from = 0; from < d; from++)    {
                if (from + A[from] >= d)    {
                    results[d] = Math.min(results[d], results[from] + 1);
                    // the results is increasing, so stop here
                    if (results[d] == results[from] + 1) break;
                }
            }
            // if we can't reach d <= n-1, we can't either for n-1 
            if (results[d] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
        }
        
        return results[n-1];
    }
}

public class JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int [] A = {2, 1};
		System.out.println(solution.jump(A));
	}

}
