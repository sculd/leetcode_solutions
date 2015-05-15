class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;
            
        int rep = (A[0] == A[1])? 2 : 1;
        int insert = rep;
        for (int i = rep; i < A.length; i++)  {
            if (A[i] == A[i-1])
                rep++;
            else
                rep = 1;

            if (rep == 1 || rep == 2)   {
                A[insert] = A[i];
                insert++;
            }
        }
        return insert;        
    }
}

public class RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int[] A = {-3,-1,0,0,0,3,3};
		System.out.println(solution.removeDuplicates(A));
	}

}
