import java.util.*;

class Solution {
    private int[] dx = {1,0,-1,0};
    private int[] dy = {0,1,0,-1};
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> r = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0)
            return r;
        int n = matrix[0].length;
        if (n == 0)
            return r;
        
        int count = 0;
        int d = 0;
        int x = -1, y = 0;
        int minX = 0, maxX = n-1;
        int minY = 0, maxY = m-1;
        while (true)    {
            int newX = x + dx[d];
            int newY = y + dy[d];
            if (newX < minX || newX > maxX || newY < minY || newY > maxY)
            {
                if (newX < minX || newY < minY)   {
                    minX -= dx[d];
                    minY -= dy[d];
                } else if (newX > maxX || newY > maxY)    {
                    maxX -= dx[d];
                    maxY -= dy[d];
                }
                d = (d + 1) % 4;
            }
            
            x += dx[d];
            y += dy[d];
            r.add(matrix[y][x]);
            
            count++;
            if (count >= m * n)
                break;
        }
        
        return r;
    }
}

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int [][] matrix = {{7, 9, 6}};
		List<Integer> r = solution.spiralOrder(matrix);
	}

}
