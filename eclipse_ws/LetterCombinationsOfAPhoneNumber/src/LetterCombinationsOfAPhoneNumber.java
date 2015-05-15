import java.util.*;

class Solution {
    private String[] table = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        result.add("");
        
        int n = digits.length();
        for (int i = n - 1; i >= 0; i--)    {
            char digit = digits.charAt(i);
            List<String> tmp = new ArrayList<String>();
            for(String str: result)
                tmp.add(str);
            
            result.clear();
            for (char newCh: table[(int)digit - (int)'0'].toCharArray())  {
               for (String str: tmp)    {
                   result.add(newCh + str);
               } 
            }
            
        }
        return result;
    }
}

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		List<String> r = solution.letterCombinations("2");
		for (String s: r)
			System.out.println(s);
	}

}
