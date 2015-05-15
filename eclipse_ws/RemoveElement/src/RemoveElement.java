import java.util.*;

class Solution {
    private void swap(int[]A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    private int skipAtTail(int[] A, int tail, int elem) {
        while (tail > 0 && A[tail-1] == elem)
            tail--;
        return tail;
    }
    
    public int removeElement(int[] A, int elem) {
        int n = A.length;
        if (n == 0) return 0;
        n = skipAtTail(A, n, elem);
        if (n == 0) return 0;
        
        for (int i = 0; i < n; i++) {
            if (A[i] == elem)   {
                n--;
                swap(A, i, n);
                n = skipAtTail(A, n, elem);
            }
        }
        
        return n;
    }
}

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int []A = {4, 5};
		System.out.println(solution.removeElement(A, 5));
	}

}
