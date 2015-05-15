class Solution {
    public String longestPalindrome(String s) {
        int longest_len = 0;
        String longest = "";
        
        for (int c = 0; c < s.length(); c++)    {
            int i = 1;
            int len = 1;
            while (true)    {
                int start = c - i;
                int end = c + i;
                
                if (start < 0 || end >= s.length())
                    break;
                
                if (s.charAt(start) != s.charAt(end))
                    break;
                    
                len = end - start + 1;
                i += 1;
            }
            if (len > longest_len)  {
                longest_len = len;
                longest = s.substring(c-len/2, c+len/2+1);
            }
        }
        
        // even len
        for (int c = 0; c < s.length(); c++)    {
            int i = 1;
            int len = 0;
            while (true)    {
                int start = c - i;
                int end = c + i - 1;
                
                if (start < 0 || end >= s.length())
                    break;
                
                if (s.charAt(start) != s.charAt(end))
                    break;
                    
                len = end - start + 1;
                i += 1;
            }
            if (len > longest_len)  {
                longest_len = len;
                longest = s.substring(c-len/2, c+len/2);
            }
        }
        
        return longest;
    }
}

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
