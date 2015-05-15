class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if (s.length() == 0)
            return result;
            
        int base = 1;
        for (int d = s.length() - 1; d >= 0; d--)   {
            int dVal = (int)(s.charAt(d)) - (int)'A' + 1; // 'A': 1, ...
            result += dVal * base;
            base *= 26;            
        }
        
        return result;
    }
}

public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
