import java.util.*;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n == 0)
            return true;
            
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else    {
                if (stack.empty())
                    return false;
                    
                Character opening = stack.pop();
                if (!(opening == '(' && ch == ')' || opening == '{' && ch == '}' || opening == '[' && ch == ']'))
                    return false;
            }
        }
        
        return stack.empty();
    }
}

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
