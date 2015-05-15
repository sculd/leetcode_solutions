import java.util.*;

class Solution {
    boolean isValid(int i, int j, char[][] grid) {
        return !(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length);
    }
    
    void explore(int i, int j, char[][] grid) {
        Queue<Integer> iq = new LinkedList<Integer>();
        Queue<Integer> jq = new LinkedList<Integer>();
        iq.add(i);
        jq.add(j);
        
        while (!iq.isEmpty())   {
            i = iq.remove();
            j = jq.remove();
            
            if (!isValid(i, j, grid))
                continue;
            
            if (grid[i][j] == '0')
                continue;
                
            grid[i][j] = '0';
            
            iq.add(i-1);    jq.add(j);
            iq.add(i+1);    jq.add(j);
            iq.add(i);    jq.add(j-1);
            iq.add(i);    jq.add(j+1);
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;
        
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')
                    continue;
                else    {
                    explore(i, j, grid);
                    count += 1;
                }
            }
        }
        
        return count;
    }
}

public class NumberOfIslands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		char[][] island = {{'0'}};
		int nIs = solution.numIslands(island);
		System.out.println(nIs);
	}

}
