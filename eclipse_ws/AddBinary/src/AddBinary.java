import java.util.*;

class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        int digits = Math.max(n, m);
        if (n < digits) {
            String tmpStr = a;
            a = b;
            b = tmpStr;
            
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        String result = "";
        int buf = 0;
        for (int digit = digits-1; digit >= 0; digit--) {
            int d1 = a.charAt(digit) - Integer.valueOf('0');
            int d2 = 0;
            int diff = n - m;
            if (digit - diff >= 0)
                d2 = b.charAt(digit - diff) - Integer.valueOf('0');
            int newD;
            
            int sum = buf + d1 + d2;
            if (sum >= 2)  {
                buf = 1;
            } else {
                buf = 0;
            }
            newD = sum % 2;
            result = newD + result;
        }
        
        if (buf > 0)
            result = buf + result;
        return result;
    }
}

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.addBinary("0", "0"));
	}

}
