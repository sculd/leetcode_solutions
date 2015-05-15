class Solution {
    public int maxProduct(int[] A) {
        int max = A[0];
        int min = A[0];
        int maxSoFar = A[0];
        int minSoFar = A[0];
        
        for(int i = 1; i < A.length; i++)   {
            int mx = maxSoFar;
            int mn = minSoFar;
            
            maxSoFar = Math.max(Math.max(mn * A[i], mx * A[i]), A[i]);
            minSoFar = Math.min(Math.min(mn * A[i], mx * A[i]), A[i]);
            
            if (maxSoFar > max)
                max = maxSoFar;
                
        }
        return max;
    }
}

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] input = {-4, -3};
		System.out.println(solution.maxProduct(input));
	}

}
