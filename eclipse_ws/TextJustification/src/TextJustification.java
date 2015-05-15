import java.util.*;

class Solution {
    int start, count, len, sumWLen;
    List<String> result;
    
    private void addNewLine(String[] words, int L, int start, int end, boolean ifLastLine)   {
        String lineStr = words[start];
        if (end > start + 1) {
            int nTotalSpaces = L - this.sumWLen;
            for (int j = start + 1; j < end; j++)    {
            	if (ifLastLine)
                    lineStr = lineStr + " ";
            	else	{
                    // from the second, put space, evenly distributed
                    int nSpace = nTotalSpaces / (end - start - 1);
                    // remaining space given to the first words
                    if ((j - start) <= nTotalSpaces % (end - start - 1))
                        nSpace += 1;
                    for (int k = 0; k < nSpace; k++)
                        lineStr = lineStr + " ";
            	}
                lineStr = lineStr + words[j];
            }
        }
        
        int lineLen = lineStr.length();
        for (int k = 0; k < L - lineLen; k++)
            lineStr = lineStr + " ";
        
        this.result.add(lineStr);
    }
    
    public List<String> fullJustify(String[] words, int L) {
        this.start = 0;
        this.count = 0;
        this.len = 0;
        this.sumWLen = 0;
        this.result = new ArrayList<String>();
        
        int n = words.length;
        if (n == 0) return this.result;
        
        for (int i = 0; i < n; i++) {
            int wlen = words[i].length();
            int inc = wlen;
            if (count > 0)
                inc += 1;
            
            if (this.len + inc > L) 
            // i should start a new line
            // write the words before i
            {
                this.addNewLine(words, L, this.start, i, false);
                this.len = wlen;
                this.sumWLen = wlen;
                this.count = 1;
                this.start = i;
            } else {
                this.len += inc;
                this.sumWLen += wlen;
                this.count++;
                
            }
        }
        this.addNewLine(words, L, this.start, n, true);
        
        return this.result;
    }
}

public class TextJustification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		String []words = {"to","a"};
		List<String> result = solution.fullJustify(words, 6);
		for (String str: result)
			System.out.println(str);
	}

}
