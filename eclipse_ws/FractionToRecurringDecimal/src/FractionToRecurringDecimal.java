import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        List<Long> history = new ArrayList<Long>();
        
        if ((long)numerator * (long)denominator < 0)  {
            result.append('-');
        }
        long numerator_long = Math.abs(numerator);
        if (numerator == Integer.MIN_VALUE)
        	numerator_long = -1 * (long)Integer.MIN_VALUE;
        long denominator_long = Math.abs(denominator);
        if (denominator == Integer.MIN_VALUE)
        	denominator_long = -1 * (long)Integer.MIN_VALUE;
        
        int dotPos = -1;
        while(true) {
            int i = history.indexOf(numerator_long);
            if (i >= 0) {
                result.insert(dotPos + 1 + i, '(');
                result.append(')');
                break;
            }
            
            if (dotPos > -1)
                history.add(numerator_long);
                
            long digit = (long)(numerator_long / denominator_long);
            result.append(digit);
            numerator_long -= digit * denominator_long;
            if (numerator_long != 0 && dotPos == -1) {
                dotPos = result.length();
                result.append('.');
            }
                
            if (numerator_long == 0)
                break;
                
            numerator_long *= 10;
        }
        
        return result.toString();
    }
}

public class FractionToRecurringDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.fractionToDecimal(-2147483648, 1));
	}

}
