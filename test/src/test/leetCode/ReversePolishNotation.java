package test.leetCode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression. For example: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

	public static void main(String args[]) {
		String ar[] = { "1", "2", "+", "4", "/" };
		System.out.println(evaluateReversePolishNotation(ar));
	}

	public static int evaluateReversePolishNotation(String[] input) {
		String operators = "+-*/";
		Stack<Integer> integerStack = new Stack<Integer>();

		for (String in : input) {
			// TODO Important line here
			if (!operators.contains(in)) {
				try {
					integerStack.push(Integer.parseInt(in));
				} catch (NumberFormatException e) {
					System.out.println("Error found");
					return -1;
				}
			} else {
				int b = integerStack.pop();
				int a = integerStack.pop();
				// In pre jdk 1.7 version, use this
				// int index = operators.indexOf(t);
				// Do switch based on index 0,1,2,3
				switch (in) {
				case "+":
					integerStack.push(a + b);
					break;
				case "-":
					integerStack.push(a - b);
					break;
				case "*":
					integerStack.push(a * b);
					break;
				case "/":
					integerStack.push(a / b);
					break;
				default:
					System.out.println("Error found");
					return -1;
				}
			}
		}
		int finalValue = integerStack.pop();
		return finalValue;
	}

}