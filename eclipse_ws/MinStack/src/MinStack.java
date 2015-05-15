import java.util.*;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        int topVal = stack.peek();
        stack.pop();
        if (topVal == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
