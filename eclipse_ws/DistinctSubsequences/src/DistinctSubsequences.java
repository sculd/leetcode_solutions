import java.util.*;

class Solution {
    /**
     * Solution (DP):
     * We keep a m*n matrix and scanning through string S, while
     * m = T.length() + 1 and n = S.length() + 1
     * and each cell in matrix Path[i][j] means the number of distinct subsequences of 
     * T.substr(1...i) in S(1...j)
     * 
     * Path[i][j] = Path[i][j-1]            (discard S[j])
     *              +     Path[i-1][j-1]    (S[j] == T[i] and we are going to use S[j])
     *                 or 0                 (S[j] != T[i] so we could not use S[j])
     * while Path[0][j] = 1 and Path[i][0] = 0.
     */
    int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();
        if (m > n) return 0;    // impossible for subsequence
        
        int [][] path = new int[m+1][n+1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                path[i][j] = 0;
    
        // initialization
        for (int k = 0; k <= n; k++) 
            path[0][k] = 1;    
    
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                path[i][j] = path[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? path[i-1][j-1] : 0);
            }
        }
    
        return path[m][n];
    }
}

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
