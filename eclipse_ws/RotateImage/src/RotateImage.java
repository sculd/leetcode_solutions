class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        
        for (int x = 1; n/2 + x < n; x++)    {
            for (int y = 0; n/2 + y < n; y++)  {
                int val = matrix[n/2 + x][n/2 + y];
                // for each of the quadru
                for (int i = 0; i < 4; i++) {
                    int xp = -y;
                    int yp = x;
                    int tmp = matrix[n/2 + xp][n/2 + yp];
                    matrix[n/2 + xp][n/2 + yp] = val;
                    val = tmp;
                }
            }
        }
    }
}

public class RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[][] matrix = {{1,2},{3,4}};
		solution.rotate(matrix);
		for (int i = 0; i < matrix.length; i++)	{
			for (int j = 0; j < matrix.length; j++)
				System.out.print(matrix[i][j]);
			System.out.println("");
		}
	}

}
