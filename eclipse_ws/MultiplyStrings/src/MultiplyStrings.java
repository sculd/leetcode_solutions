class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        
        int[] mul = new int[m + n];

        for(int i = 0; i < m; i++)  {
            int d1 = (int)(num1.charAt(i)) - (int)('0');
            int b1 = num1.length() - i - 1;
            for(int j = 0; j < n; j++)  {
                int d2 = (int)(num2.charAt(j)) - (int)('0');
                int b2 = num2.length() - j - 1;
                
                mul[b1 + b2] += (d1 * d2) % 10;
                mul[b1 + b2 + 1] += (d1 * d2) / 10;
            }
        }    
        
        for(int i = 0; i <= m + n - 2; i++)  {
            mul[i+1] += mul[i] / 10;
            mul[i] = mul[i] % 10;
        }
        
        StringBuilder sb = new StringBuilder();
        int leading = m + n -1;
        while (mul[leading] == 0)   {
            leading--;
            if (leading == 0)
                break;
        }
        
        for (int i = leading; i >= 0; i--)    {
            sb.append((char)(mul[i] + (int)('0')));
        }
        
        return sb.toString();
    }
}

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.multiply("123", "456"));
	}

}
