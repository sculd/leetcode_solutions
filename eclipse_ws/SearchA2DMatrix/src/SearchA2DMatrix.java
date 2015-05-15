class Solution {
    private boolean searchRow(int[] row, int head, int tail, int target)    {
        int m = (head + tail) / 2;
        if (head >= tail)
            return false;
        
        if (row[m] == target)
            return true;
        else if (row[m] > target)
            return searchRow(row, head, m, target);
        else
            return searchRow(row, m + 1, tail, target);
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;

        int n = matrix[0].length;
        if (n == 0)
            return false;
            
        boolean ifFound = false;
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] <= target && matrix[r][n-1] >= target) {
                ifFound = searchRow(matrix[r], 0, n, target);
                break;
            }
        }
        
        return ifFound;
    }
}

public class SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
