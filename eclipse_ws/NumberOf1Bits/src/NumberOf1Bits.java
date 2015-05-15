class Solution {
    // you need to treat n as an unsigned value
	public int hammingWeight_simple(int n) {
		int h_weight = 0;
	        
	    while (n != 0)  {
	    	h_weight += (n & 1);
	    	n >>>= 1;
	    }
	    return h_weight;
	 }

    public int hammingWeight(int n) {
        int base = 1;
        int h_weight = 0;
        int d = 0;
        while (true)    {
            h_weight += ((base & n) != 0)? 1 : 0;
            
            d += 1;
            if (d >= 32)    break;
            base <<= 1;
        }
        
        return h_weight;
    }
}

public class NumberOf1Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.hammingWeight_simple(-2147483648));
		System.out.println(solution.hammingWeight_simple(-1));
	}
}
