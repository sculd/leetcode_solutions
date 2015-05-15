import java.util.*;

class Solution {
    public int search(int[] A, int head, int tail, int target) {
        if (head >= tail)
            return -1;
        
        int m = (head + tail) / 2;
        
        if (A[m] == target)
            return m;
        else if (A[head] < A[m])   {
            // head~m is sorted
            if (A[m] > target && target >= A[head])
                return search(A, head, m, target);
            else
                return search(A, m+1, tail, target);
        } else  {
            // m~tail is sorted
            if (A[m] < target && target <= A[tail-1])
                return search(A, m+1, tail, target);
            else
                return search(A, head, m, target);
        }
    }
    
    public int search(int[] A, int target) {
        if (A.length == 0)
            return -1;
        return search(A, 0, A.length, target);
    }
}

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] A = {3,1};
		int target = 3;
		System.out.println(solution.search(A, target));
	}
}
