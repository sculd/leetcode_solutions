class Solution {
    private int searchInsert(int[] A, int head, int tail, int target) {
        if (head == tail)
            return head;
            
        int m = (head + tail) / 2;
        if (A[m] == target)
            return m;
        else if (A[m] > target)
            return searchInsert(A, head, m, target);
        else
            return searchInsert(A, m + 1, tail, target);
    }
    
    public int searchInsert(int[] A, int target) {
        return searchInsert(A, 0, A.length, target);
    }
}

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
