class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (n == 0)
            return 0;
            
        int lead = 1;
        while (true)    {
            if (lead << 1 > 0 && n >= lead << 1)
                lead = lead << 1;
            else
                break;
        }
        
        int result = 0;
        while (true)    {
            if (lead == 0 || (m & lead) != (n & lead))
                break;
            
            result |= (m & lead);
            lead = lead >> 1;
        }

        return result;
    }
}

/*
16: n >= 16, not n = 8 + ...
16 + 8: n >= 8, not n = 4 + ...
if n = 8, then n...m is 8, 8+1, ..., 8 + 4 + 2 + 1, (no overlap) 16, 16 + 1, ..., 16 + 8

m = 10 = 8 + 2
n = 11 = 8 + 2 + 1

the result is non-zero only when the leading digit or m and n are the same. 
The value of the result is the leading identical parts of m and n

e.g. (1, 0): 0
(0, 0): 0
*/

public class BitwiseANDOfNumbersRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new Solution()).rangeBitwiseAnd(1, 3));
	}
}
