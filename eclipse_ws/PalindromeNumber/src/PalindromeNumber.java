class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
            
        int upperBase = 1;
        while (true)    {
            if ((long)upperBase * 10 > x)
                break;
            upperBase *= 10;
        }
        
        int lowerBase = 1;
        
        while (true)    {
            int upperDigit = (x / upperBase) % 10;
            int lowerDigit = (x / lowerBase) % 10;
            
            if (upperDigit != lowerDigit)
                return false;
            
            upperBase = upperBase / 10;
            lowerBase = lowerBase * 10;
            
            if (upperBase <= lowerBase)
                break;
        }
        
        return true;
    }
}

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
