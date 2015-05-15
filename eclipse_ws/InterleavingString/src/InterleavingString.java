import java.util.*;

class Solution {
    private static Set<Integer> visited; // The combination of i1, i2 has been visited and return false
    
	public boolean isInterleaveRecursive(String s1, String s2, String s3, int i, int j) {        
        while (true)    {
            if (i == s1.length() && j == s2.length() && i + j == s3.length())   
                return true;

            int hash = s3.length() * i + j; 
            if (visited.contains(hash))
                return false;
            
            if (i == s1.length())   {
                return s3.substring(i + j).compareTo(s2.substring(j)) == 0;
            }

            if (j >= s2.length())   
                return s3.substring(i + j).compareTo(s1.substring(i)) == 0;

            char ch3 = s3.charAt(i + j);
            if (ch3 == s1.charAt(i))    {
                if (s2.charAt(j) != ch3)
                    i += 1;
                else    {
                    // recursive call
                    return isInterleaveRecursive(s1, s2, s3, i + 1, j) || isInterleaveRecursive(s1, s2, s3, i, j + 1);
                }
            } else if (ch3 == s2.charAt(j))
                j += 1;
            else
                return false;
            
            visited.add(hash);
        }
    }
	
    public boolean isInterleaveIterative(String s1, String s2, String s3) {
        Queue<Integer> iQ = new LinkedList<Integer>();
        Queue<Integer> jQ = new LinkedList<Integer>();
        
        iQ.add(0);
        jQ.add(0);

        while (true)    {
            if (iQ.isEmpty()) 
                return false;
                
            int i = iQ.remove();
            int j = jQ.remove();
            
            if (i + j == s3.length())   
                return true;
            else if (i == s1.length())   {
                iQ.add(i);
                jQ.add(j + 1);
            }
            else if (j == s2.length())   {
                iQ.add(i + 1);
                jQ.add(j);
            } else {
                char ch3 = s3.charAt(i + j);
                if (ch3 == s1.charAt(i))    {
                    if (s2.charAt(j) != ch3)    {
                        iQ.add(i + 1);
                        jQ.add(j);
                    }   else    {
                        iQ.add(i + 1);
                        jQ.add(j);
                        
                        iQ.add(i);
                        jQ.add(j + 1);
                    }
                } else if (ch3 == s2.charAt(j)) {
                    iQ.add(i);
                    jQ.add(j + 1);
                }
            }
        }
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        visited = new HashSet<Integer>();
    	return isInterleaveRecursive(s1, s2, s3, 0, 0);
        //return isInterleaveIterative(s1, s2, s3);
    }
}

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		//String s1 = "abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb";
		//String s2 = "ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc";
		//String s3 = "cacbabbacbbbabcbaacbbaccacaacaacccabababbbababcccbabcabbaccabcccacccaabbcbcaccccaaaaabaaaaababbbbacbbabacbbacabbbbabc";
		String s1 = "a";
		String s2 = "b";
		String s3 = "a";
		System.out.println(solution.isInterleave(s1, s2, s3));
	}
}
