import java.util.Stack;

/*Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Hide Company Tags LinkedIn
Hide Tags Stack
Hide Similar Problems (H) Basic Calculator (H) Expression Add Operators
 */
public class EvaluateReversePolishNotation150 {
	public int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0)
			return 0;

		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < tokens.length; i++) {
			if (!tokens[i].equals("+") && !tokens[i].equals("-")
					&& !tokens[i].equals("*") && !tokens[i].equals("/")) {
				stack.push(tokens[i]);
			} else {
				int tempRes = 0;
				int operand2 = Integer.parseInt(stack.pop());
				int operand1 = Integer.parseInt(stack.pop());

				if (tokens[i].equals("+"))
					tempRes = operand1 + operand2;

				if (tokens[i].equals("-"))
					tempRes = operand1 - operand2;

				if (tokens[i].equals("*"))
					tempRes = operand1 * operand2;

				if (tokens[i].equals("/"))
					tempRes = operand1 / operand2;

				stack.push(Integer.toString(tempRes));
			}
		}

		return Integer.parseInt(stack.pop());
	}
}
