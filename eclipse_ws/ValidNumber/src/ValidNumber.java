class Solution {
    private boolean isDigit(char ch) {
        return Integer.valueOf(ch) >= Integer.valueOf('0') && Integer.valueOf(ch) <= Integer.valueOf('9');
    }
    
    private boolean isDigits(String str, boolean ifSignAllowed)    {
        int n = str.length();
        if (n == 0) return false;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+')   {
        	if (!ifSignAllowed)
        		return false;
            str = str.substring(1);
            n--;
        }
        if (n == 0) return false;
        
        for (int i = 0; i < n; i++)
            if (!isDigit(str.charAt(i)))
                return false;
        return true;
    }
    
    private boolean isPureNumber(String str) {
        int n = str.length();
        if (n == 0) return false;
        
        if (str.charAt(0) == '-' || str.charAt(0) == '+')   {
            str = str.substring(1);
            n--;
        }
        if (n == 0) return false;
        if (str.equals(".")) return false;
        
        int dotIndex = str.indexOf('.');
        if (dotIndex < 0)
            return isDigits(str, true);
        else
            return (dotIndex == 0 || isDigits(str.substring(0, dotIndex), true)) && (dotIndex == n-1 || isDigits(str.substring(dotIndex + 1), false));
    }
    
    public boolean isNumber(String s) {
        s = s.trim();
        int  eIndex = s.indexOf('e');
        if (eIndex < 0)
            return isPureNumber(s);
        else {
            return isPureNumber(s.substring(0, eIndex)) && isDigits(s.substring(eIndex + 1), true);
        }
    }
}

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.isNumber("6e6.5"));
	}

}
