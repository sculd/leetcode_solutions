class Solution {
    private int search(int[] A, int head, int tail, int target) {
        if (head >= tail)
            return -1;
        
        int m = (head + tail) / 2;
        if (A[m] == target)
            return m;
        else if (A[m] > target)
            return search(A, head, m, target);
        else
            return search(A, m + 1, tail, target);
    }
    
    public int[] searchRange(int[] A, int target) {
        int found = search(A, 0, A.length, target);
    	int [] r = {-1, -1};
        if (found == -1)
        	;
        else    {
            int head = (found > 0 && A[found-1] == target)? found - 1 : found;
            while (head > 0 && A[head-1] == target)
                head--;
                
            int tail = (found < A.length - 1 && A[found+1] == target)? found + 1 : found;
            while (tail < A.length - 1 && A[tail+1] == target)
                tail++;

            r[0] = head;
            r[1] = tail;
        }
        return r;
    }
}

public class SearchforARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
