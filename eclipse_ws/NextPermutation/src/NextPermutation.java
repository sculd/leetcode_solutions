import java.util.*;

class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1)
            return;
            
        int pivot = num.length - 2;
        // find the pivot, keeping the smallest (but larger than pivot) after the pivot
        while (true)    {
            if (pivot == -1)
                break;
            
            // pivot is the first point from the end backward where the number from the end starts to decrease
            // e.g.: 3 in 1 3 4 2
            if (num[pivot] < num[pivot+1])
                break;
                
            pivot -= 1;
        }

        // swap the pivot and the smallest after the pivot
        if (pivot > -1) {
            // find the smallest (but larger than the one at the pivot) after the pivot
            int smallest = num.length;
            for (int i = num.length-1; i > pivot; i--) {
                smallest = (num[pivot] < num[i] && (smallest == num.length || num[smallest] > num[i]))? i : smallest;
            }
            
            int tmp = num[pivot];
            num[pivot] = num[smallest];
            num[smallest] = tmp;
        }
        Arrays.sort(num, pivot + 1, num.length);
    }
}

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
