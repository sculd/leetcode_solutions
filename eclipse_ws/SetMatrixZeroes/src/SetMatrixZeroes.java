class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        if (n == 0)
            return;
        
        int l = Math.max(m, n);
        int[] marks = new int[l];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)  {
                    marks[i] |= 1;
                    marks[j] |= 2;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((marks[i] & 1) > 0 || (marks[j] & 2) > 0)
                    matrix[i][j] = 0;
            }
        }
    }
}

public class SetMatrixZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
