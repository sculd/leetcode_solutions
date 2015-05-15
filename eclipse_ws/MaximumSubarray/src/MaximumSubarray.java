class Solution {
    public int maxSubArray(int[] A) {
        if (A.length == 0)
            return 0;
            
        int max = A[0];
        int subMax = A[0];
        
        for (int i = 1; i < A.length; i++)  {
            if (subMax < 0)
                subMax = A[i];
            else
                subMax = subMax + A[i];
            
            max = Math.max(max, subMax);
        }
        
        return max;
    }
}

public class MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
