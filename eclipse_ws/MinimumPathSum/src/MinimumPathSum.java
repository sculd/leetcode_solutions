class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int[][] sum = new int[m+1][n+1];
        for (int row = m-1; row >= 0; row--)
            sum[row][n] = Integer.MAX_VALUE;
            
        for (int col = n-1; col >= 0; col--)
            sum[m][col] = Integer.MAX_VALUE;
        
        sum[m-1][n] = 0;
            
        for (int row = m-1; row >= 0; row--)   {
            for (int col = n-1; col >= 0; col--)   {
                sum[row][col] = grid[row][col] + Math.min(sum[row+1][col], sum[row][col+1]);
            }
        }
        
        return sum[0][0];
    }
}

public class MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
