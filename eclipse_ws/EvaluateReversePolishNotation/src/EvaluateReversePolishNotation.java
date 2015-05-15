import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].compareTo("+") == 0 || tokens[i].compareTo("-") == 0 || tokens[i].compareTo("*") == 0 || tokens[i].compareTo("/") == 0)   {
                int val2 = stack.pop();
                int val1 = stack.pop();
                if (tokens[i].compareTo("+") == 0)
                    stack.push(val1 + val2);
                else if (tokens[i].compareTo("-") == 0)
                    stack.push(val1 - val2);
                else if (tokens[i].compareTo("*") == 0)
                    stack.push(val1 * val2);
                else if (tokens[i].compareTo("/") == 0)
                    stack.push(val1 / val2);
            } else 
                stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }
}
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] tokens = new String[3];
		tokens[0] = "0";
		tokens[1] = "3";
		tokens[2] = "/";
		
		System.out.println(solution.evalRPN(tokens));
	}

}
