import java.util.Stack;

/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.*/
public class minStack155 {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	public void push(int x) {
		if (getMin() >= x)
			s2.push(x);
		s1.push(x);
	}

	public void pop() {
		if (s2.peek().equals(s1.peek()))
			s2.pop();
		s1.pop();
	}

	public int top() {
		return s1.peek();
	}

	public int getMin() {
		if (s2.isEmpty())
			return Integer.MAX_VALUE;
		else
			return s2.peek();
	}
}
