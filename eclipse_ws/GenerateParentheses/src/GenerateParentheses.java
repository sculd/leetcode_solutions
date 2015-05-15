import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
    	List<List<String>> results = new ArrayList<List<String>>();
    	for (int i = 0; i < n+1; i++)
    			results.add(new ArrayList<String>());
        results.get(0).add("");
        results.get(1).add("()");

        for (int m = 2; m <= n; m++)    {
            for (int i = 1; i <= m; i++) {
                for (String p1 : results.get(i-1)) {
                    for (String p2 : results.get(m-i)) {
                        results.get(m).add("(" + p1 + ")" + p2);
                    }
                }
            }
        }
        
        return results.get(n);
    }
}

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		List<String> result = solution.generateParenthesis(3);
		for (String str : result)
			System.out.println(str);
	}

}
