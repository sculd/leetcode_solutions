class Solution {
    public long longDivide(long p, long q)  {
        if (q == 0)
            return Integer.MAX_VALUE;
            
        int sign = 1;
        if (p < 0 && q > 0 || p > 0 && q < 0)
            sign = -1;
            
        if (p < q)
            return 0;
            
        long result = 0;
        while (p >= q) {
            long tmp_q = q;
            long add = 1;
            while (p >= tmp_q << 1)  {
                tmp_q = tmp_q << 1;
                add = add << 1;
            }
            p -= tmp_q;
            result += add;
        }
        
        return sign * result;
    }
    
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            return Integer.MAX_VALUE;
        
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
            sign = -1;
            
        long p = (long)Math.abs((long)dividend);
        long q = (long)Math.abs((long)divisor);
        
        long longResult = (sign * longDivide(p, q));
        if (longResult > Integer.MAX_VALUE || longResult < Integer.MIN_VALUE)
        	return Integer.MAX_VALUE;
        else
        	return (int)longResult;
    }
}

public class DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.divide(-2147483648, -1));
	}

}
