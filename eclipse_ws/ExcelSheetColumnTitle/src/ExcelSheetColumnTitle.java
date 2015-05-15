class Solution {
    private String convertToChar(int n) {
    	// 1: A, 2: B, ..., 26: Z
    	return new Character((char)((int)'A' + (n - 1))).toString();
    }
        
    public String convertToTitle(int n) {
    	n = n - 1;
    	int base = 1;
    	while (true)	{
    		if ((long)base * 26 > (long)n)
    			break;
    		else
    			base *= 26;
    	}
    	
    	// the base for the first digit is 27
    	// e.g. ZX
    	if (base > 1)
    		base = base / 26 * 27;
    	
    	String result = "";
    	boolean ifFirstDigit = true;
		int multiplyer = 27;
    	while (true)	{
        	int digit = n / base;
        	n -= digit * base;
        	
        	if (ifFirstDigit)	{
        		// the base of the leading digit is 27, not 26
            	// if the first digit is 0, proceed like nothing happened
        		if (digit == 0 && base > 1)
        			n += digit * base;
        		else	{
        			if (base > 1)
        				result = result + convertToChar(digit);
        			else
        				result = result + convertToChar(digit + 1);
        			ifFirstDigit = false;
                	multiplyer = 26;
        		}
        	}	else
        		result = result + convertToChar(digit + 1);
        	
        	if (base == 1)	{
        		break;
        	} else {
        		base /= multiplyer;
        	}
    	}
    	
    	return result;
    }
}

public class ExcelSheetColumnTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.convertToTitle(27));
	}

}
