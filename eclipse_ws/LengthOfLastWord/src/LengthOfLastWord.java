import java.util.*;

class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) return 0;
        
        int prevLen = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != ' ') {
                len++; 
            } else {
                prevLen = len == 0 ? prevLen : len;
                len = 0;
            }
        }
        
        return len == 0 ? prevLen : len;
    }
}

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
