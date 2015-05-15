class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
            
        int[] ways = new int[m+1];
        
        // init
        for (int row = 0; row < m; row++) 
            ways[row] = 1;
        
        for (int col = n-2; col >= 0; col--)    {
            for (int row = m-1; row >= 0; row--)    {
                ways[row] = ways[row] + ways[row+1];
            }
        }
        
        return ways[0];
    }
}

public class UniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
