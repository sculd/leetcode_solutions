import java.util.*;

class Solution {
    public int findMinLogTime(int[] num) {
        int head = 0;
        int tail = num.length;
        if (tail == 0)
            return 0;
        else if (tail == 1)
            return num[0];

        while (true)    {
            if (tail - head <= 1)
                return num[head];
            
            if (num[head] < num[tail-1])
                return num[head];
            
            int m = (head + tail) / 2;
            if (num[m-1] > num[m])   {
                return num[m];
            }
            
            if (num[head] == num[tail-1])   {
                tail--;
            } else if (num[head] > num[m]) {
                tail = m;
            } else {
                head = m+1;
            }
        }
    }
    
    public int findMin(int[] num) {
        int n = num.length;
        
        if (n == 1)
            return num[0];
            
        int prev = num[0];
        for (int i = 1; i < n; i++) {
            if (num[i] < prev)
                return num[i];
        }
        return num[0];
    }
}

public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
