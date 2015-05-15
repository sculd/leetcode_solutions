import java.util.*;

class Solution {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    private boolean fill(char[][] board, int i, int j)  {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;
        
        if (board[i][j] == 'X')
            return true;
                    
        // board[i][j] == 'O'
        board[i][j] = 'X';
        for (int n = 0; n < 4; n++) {
            if (!fill(board, i + dx[n], j + dy[n])) {
                // roll back
                board[i][j] = 'O';
                return false;
            }
        }
        
        return true;
    }
    
    private void solve_recursive(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                fill(board, i, j);
    }
    
    private class Point {
        public int x, y;
        public Point(int x, int y)  {
            this.x = x;
            this.y = y;
        }
    }
    private boolean fill_BFS(char[][] board, int i, int j, Queue<Point> frontier, Queue<Point> explored)  {
        
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
            return false;
        
        if (board[i][j] == 'X')
            return true;
                    
        // board[i][j] == 'O'
        explored.add(new Point(i, j));
        board[i][j] = 'X';
        for (int n = 0; n < 4; n++) {
            frontier.add(new Point(i + dx[n], j + dy[n]));
        }
        
        return true;    
    }
    
    private void solve_BFS(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        
        Queue<Point> frontier = new LinkedList<Point>();
        Queue<Point> explored = new LinkedList<Point>();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                frontier.add(new Point(i, j));
                while (!frontier.isEmpty()) {
                    Point p = frontier.remove();    
                    
                    if (!fill_BFS(board, p.x, p.y, frontier, explored)) {
                        frontier.clear();
                        for (Point e: explored) {
                            board[e.x][e.y] = 'O';
                        }
                        explored.clear();
                    }
                }
                explored.clear();
            }
    }
    
    public void solve(char[][] board) {
        solve_BFS(board);
    }
}

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		char[][] board = {	{'X','X','X','X','X'},
							{'X','O','O','X','O'},
							{'X','X','O','O','X'},
							{'X','O','X','X','O'},
							{'X','O','X','X','X'}
		};
		
		solution.solve(board);
		for (char[] row: board){
			for (char c: row)
				System.out.print(c);
			
			System.out.println("");
		}
		
	}

}
