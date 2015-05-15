import java.util.*;

class Solution {
    public String convert(String s, int nRows) {
        if (nRows == 1) return s;
        
        List<String> rows = new ArrayList<String>();
        for (int i = 0; i < nRows; i++) rows.add("");
            
        String result = "";
        int row = 0;
        boolean ifRowIncreasing = true;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            rows.set(row, rows.get(row) + ch);
            
            if (ifRowIncreasing && row == nRows - 1)
                ifRowIncreasing = false;
            else if (!ifRowIncreasing && row == 0)
                ifRowIncreasing = true;

            if (ifRowIncreasing)
                row += 1;
            else
                row -= 1;
        }
        
        for (int i = 0; i < nRows; i++)
            result = result + rows.get(i);
        
        return result;
    }
}
public class ZigZagConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String input = "npqohegcqdpqmffzllfjruicotyajfxywnmfrvjkyzclghmtvtconmqbfqeowbpsrbaiwjuvixiqgwjbporcaiggakww";
		int nRows = 84;
		System.out.println(solution.convert(input, nRows));
	}

}
