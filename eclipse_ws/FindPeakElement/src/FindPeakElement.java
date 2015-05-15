class Solution {
    public int findPeakElement(int[] num) {
        int n = num.length;
        if (n == 0) return 0;
        if (n == 1) return 0;
        if (n == 2) return num[0] > num[1]? 0 : 1;
        
        for (int i = 0; i <= n - 1; i++)    {
            if (i == 0 && num[0] > num[1])
                return 0;
            else if (i == n-1 && num[n-1] > num[n-2])
                return n-1;
            else if (i > 0 && i < n-1 && num[i] > num[i-1] && num[i] > num[i + 1])
                return i;
        }
        
        return 0;
    }
}

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
