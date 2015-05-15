class Solution_improved {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }});
        
        if (strs.length == 0)
            return "";
        
        String longest = strs[0];
        int pos = longest.length();
        for (int s = 1; s < strs.length; s++)   {
            if (pos == 0)
                break;
            
            for (int i = 0; i < pos; i++)   {
                if (i >= strs[s].length() || strs[s].charAt(i) != longest.charAt(i))  {
                    pos = i;
                    break;
                }
            }
        }
        
        return longest.substring(0, pos);
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int n = strs.length;
        if (n == 0)
            return prefix;
        
        int pos = 0;
        while (true)    {
            if (pos >= strs[0].length())
                break;
                
            boolean ifAdd = true;
            char newChar = strs[0].charAt(pos);
            for (int i = 1; i < n; i++) {
                if (pos >= strs[i].length() || newChar != strs[i].charAt(pos))  {
                    ifAdd = false;
                    break;
                }
            }
            
            if (ifAdd)  {
                prefix = prefix + String.valueOf(newChar);
                pos++;
            }   else
                break;
        }
        
        return prefix;
    }
}

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
