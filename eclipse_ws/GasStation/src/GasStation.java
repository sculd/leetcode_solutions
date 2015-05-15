import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n  = gas.length;
        
        int [] saves = new int[n];
        // initialize
        int sum = 0;
        for (int i = 0; i < n; i++) {
            saves[i] = gas[i] - cost[i];
            sum += saves[i];
        }
        if (sum < 0)
            return -1;

        // scan
        boolean ifEndReached = false;
        boolean ifSumStarted = false;
        int i = 0;
        int start = 0;
        int cumulative = 0;
        while (true)    {
            // survived
            if (ifEndReached && i == start)
                break;
            
            if (saves[i] > 0 && !ifSumStarted)  {
                if (ifEndReached)   {
                    return -1;
                }
                
                start = i;    
                cumulative = 0;
                ifSumStarted = true;
            }
            
            if (ifSumStarted)
                cumulative += saves[i];

            if (cumulative < 0)  {
                cumulative = 0;
                ifSumStarted = false;                
            }
                
            if (i == n - 1)
                ifEndReached = true;
                
            i = (i + 1) % n;
        }
        
        return start;
    }
}

public class GasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int []gas = {1,2};
		int []cost = {2,1};
		System.out.println(solution.canCompleteCircuit(gas, cost));

	}

}
