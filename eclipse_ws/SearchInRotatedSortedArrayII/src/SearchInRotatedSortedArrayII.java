class Solution {
    public boolean search(int[] A, int target) {
        int head = 0;
        int tail = A.length;
        
        while (true)    {
            if (head >= tail)
                break;
            
            int m = (head + tail) / 2;
            
            if (A[m] == target)
                return true;
            else if (A[m] == A[head] && A[m] == A[tail-1]) {
                head += 1;
                tail -= 1;
            } else if (A[head] <= A[m])   {
                // head~m is sorted
                if (A[m] > target && target >= A[head])
                    tail = m;
                else
                    head = m + 1;
            } else  {
                // m~tail is sorted
                if (A[m] < target && target <= A[tail-1])
                    head = m + 1;
                else
                    tail = m;
            }
        }            
        return false;
    }    
}

public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
