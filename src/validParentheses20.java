import java.util.Stack;

public class validParentheses20 {
	public boolean isValid(String s) {
		if (s.length() == 0 || s == null)
			return true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
				stack.push(s.charAt(i));
			else {
				if (stack.isEmpty())
					return false;
				char top = stack.pop();
				if (s.charAt(i) == ')')
					if (top != '(')
						return false;
				if (s.charAt(i) == ']')
					if (top != '[')
						return false;
				if (s.charAt(i) == '}')
					if (top != '{')
						return false;
			}
		}

		return stack.isEmpty();

	}
}
