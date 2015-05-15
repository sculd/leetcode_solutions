class Solution {
    public int numTrees(int n) {
        int nums[] = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        
        for (int i = 2; i <= n; i++)    {
            for (int m = 0; m < i; m++) {
                int l = nums[m];
                int r = nums[i-m-1];
                nums[i] += l * r;
            }
        }
        
        return nums[n];
    }
}

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new Solution()).numTrees(3));
	}

}
