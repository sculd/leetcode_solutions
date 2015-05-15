import java.util.*;

class Solution {
    private Map<Character, Integer> romanToNumber = new HashMap<Character, Integer>()  {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;
            
        int result = romanToNumber.get(s.charAt(0));
        int prev = result;
        for (int c = 1; c < s.length(); c++)   {
            int val = romanToNumber.get(s.charAt(c));
            result += val;
            if (val > prev)
                result -= 2 * prev;
            prev = val;
        }
        return result;
    }
}

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
