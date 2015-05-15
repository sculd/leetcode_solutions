import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (n < m)
            return -1;
        if (m == 0)
            return -1;
        List<Integer> positions = new ArrayList<Integer>();
        
        for (int i = 0; i < n; i++) {
            char ch = haystack.charAt(i);
            int nPos = positions.size();
            for (int j = nPos - 1; j > 0; j--)    {
                int pos = positions.get(j);
                if (ch == needle.charAt(pos))   {
                    pos++;
                    if (pos == m)   {
                        return i - m + 1;
                    } else {
                        positions.set(j, pos);
                    }
                } else {
                    positions.remove(j);
                }
            }
            
            if (ch == needle.charAt(0)) {
                if (m == 1)
                    return i;
                else
                    positions.add(1);
            }
        }
        
        return -1;
    }
}

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
