import java.util.*;

class Solution {
    public boolean canJump(int[] A) {
        int n = A.length;
        int jumps = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] > jumps)
                jumps = A[i];
                
            if (i == n-1 && jumps >= 0)
                return true;
                
            if (jumps == 0)
                return false;
            
            jumps--;
        }
        return true;
    }
}

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
