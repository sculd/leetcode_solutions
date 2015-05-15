class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if (n <= 1)
            return n;
            
        int insert = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] != A[i-1]) {
                A[insert] = A[i];
                insert++;
            }
        }
        
        return insert;
    }
}

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
