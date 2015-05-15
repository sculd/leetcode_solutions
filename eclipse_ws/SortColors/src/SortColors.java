import java.util.*;

class Solution {
    private void swap(int[] A, int i, int j)    {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    private int pushToBack(int[] A, int end, int value)    {
        // push the elements of the value to the end, but no further than 'end'
        int tail = end + 1;
        int head = -1;
        boolean ifTailMove = true;
        boolean ifHeadMove = true;
        while (true)    {
            // move the tail until it finds the non-value element
            while (ifTailMove) {
                tail--;
                if (tail < 0) break;
                ifTailMove = (A[tail] == value ? true : false);
            }
            
            // move the head until it finds the element with the value
            while (ifHeadMove)   {
                head++;
                ifHeadMove = head < tail && head < end && (A[head] == value ? false : true);
            }
            
            if (head >= tail)
                break;
                
            swap(A, head, tail);
            ifTailMove = tail > 0;
            ifHeadMove = head < tail && head < end;
        }
        
        return tail;
    }
    
    public void sortColors(int[] A) {
        int n = A.length;
        int end = pushToBack(A, n-1, 2);
        if (end < 0) return;
        end = pushToBack(A, end, 1);
        if (end < 0) return;
    }
}

public class SortColors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
