import java.util.*;

class Solution {
    public String countAndSay(int n) {
        String seq = "1";
        if (n == 1) return seq;
        
        for (int iter = 1; iter < n; iter++) {
            char ch = seq.charAt(0);
            int rep = 1;
            
            int len = seq.length();
            String tmpSeq = seq;
            seq = "";
            for (int i = 1; i < len; i++) {
                char newCh = tmpSeq.charAt(i);
                if (newCh == ch)
                    rep++;
                else    {
                    seq = seq + rep + ch;
                    ch = newCh;
                    rep = 1;
                }
            }
            seq = seq + rep + ch;
        }
        return seq;
    }
}

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.countAndSay(2));
	}

}
