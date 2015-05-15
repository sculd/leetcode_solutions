class Solution {
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return new int[0][0];
        int[][] r = new int[n][n];
        int d = 0;
        int x = -1, y = 0;
        int count = 0;
        while(true) {
            // at boundary
            if (x + dx[d] < 0 || x + dx[d] >= n || y + dy[d] < 0 || y + dy[d] >= n)
                d = (d+1) % 4;
            // at already filled block
            else if (r[y + dy[d]][x + dx[d]] != 0)
                d = (d+1) % 4;
                
            x += dx[d];
            y += dy[d];
            
            r[y][x] = ++count;
            if (count == n * n)
                break;
        }
        
        return r;
    }
}

public class SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
