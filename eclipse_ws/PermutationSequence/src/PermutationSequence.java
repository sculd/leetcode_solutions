class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[10];
        factorials[0] = 1;
        for (int i = 1; i <= 9; i++)
            factorials[i] = factorials[i-1] * i;
        
        StringBuilder str = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            int index = (k-1) / factorials[i];
            str.append(index + 1);
            k -= index * factorials[i];
        }
        
        for (int i = str.length() - 2; i >= 0; i--)  {
            char ch = str.charAt(i);
            for (int j = i + 1; j < str.length(); j++)  {
                if (str.charAt(j) >= ch)
                    str.setCharAt(j, (char)((int)str.charAt(j) + 1));
            }
        }
        
        return str.toString();
    }
}

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.getPermutation(8, 8590));
	}

}
