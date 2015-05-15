class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0)
            return 0;
        
        int n = obstacleGrid[0].length;
        if (n == 0)
            return 0;
        
        int[] ways = new int[m+1];
        
        // init
        ways[m-1] = (obstacleGrid[m-1][n-1] == 1)? 0 : 1;
        for (int row = m-2; row >= 0; row--)    {
            ways[row] = (obstacleGrid[row][n-1] == 1)? 0 : ways[row+1];
        }
        
        for (int col = n-2; col >= 0; col--)    {
            for (int row = m-1; row >= 0; row--)    {
                ways[row] = (obstacleGrid[row][col] == 1)? 0 : ways[row] + ways[row+1];
            }
        }
        
        return ways[0];
    }
}

public class UniquePathsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
