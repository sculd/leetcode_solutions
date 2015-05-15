import java.util.*;

class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int nextN = n;
        while (true)    {
            n = nextN;
            if (n == 0)
                break;
            
            int i = 0;
            int j = 0;
            while (true)    {
                if (j == n)
                // scanned all B
                    break;
                else if (i == m) 
                // append B's val at the end of A
                {
                    A[i] = B[j];
                    nextN -= 1;
                    m += 1;
                    i += 1;
                    j += 1;
                }
                else if (A[i] <= B[j])
                // proceed A
                    i += 1;
                else    
                // swap A and B and proceed one step
                {
                    int tmp = A[i];
                    A[i] = B[j];
                    B[j] = tmp;
                    i += 1;
                    j += 1;
                }
            }
        }
    }
}

public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
