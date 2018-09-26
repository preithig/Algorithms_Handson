package com.citi;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class EvalArithmeticExp {

	private static String commentStr = "Please enter an arithmetic expression (Operations supported is +, -, *, /, % and ^ (power) ) and press Enter to evaluate.  To quit the program, simply press Enter.";
	private static String arithExprRegex = "^\\d+[\\+\\-\\*\\/\\%\\^]\\d+([\\+\\-\\*\\/\\%\\^]\\d+)*$";

	private static Pattern arithExprPattern = Pattern.compile(arithExprRegex);

	public static void main(String args[]) {
		System.out.println(commentStr);
		Scanner scanner = new Scanner(System.in);

		String inputExpr = null;
		try {
			while ((inputExpr = scanner.nextLine().replaceAll("\\s+", ""))
					.length() > 0) {
				if (!(arithExprPattern.matcher(inputExpr).find())) {
					System.out.println("Invalid Arithmetic Expression...");
					System.out.println(commentStr);
					continue;
				}

				System.out.println("Result: " + evaluateExpression(inputExpr));
				System.out.println(commentStr);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	public static double evaluateExpression(String inputExpr) {

		Stack<Double> numberStack = new Stack<>();
		Stack<Character> operationStack = new Stack<>();

		char[] charToken = inputExpr.toCharArray();

		for (int i = 0; i < charToken.length; i++) {
			if (charToken[i] >= '0' && charToken[i] <= '9') {
				StringBuilder sb = new StringBuilder();
				//Also why this is needed
				while (i < charToken.length
						&& (charToken[i] >= '0' && charToken[i] <= '9')) {
					sb.append(charToken[i++]);
				}
				i--; // Please mention why are you doing this
				numberStack.push(Double.parseDouble(sb.toString()));
			} else if (charToken[i] == '+' || charToken[i] == '-'
					|| charToken[i] == '*' || charToken[i] == '/'
					|| charToken[i] == '%' || charToken[i] == '^') {
				while (!operationStack.isEmpty()
						&& precedence(operationStack.peek()) >= precedence(charToken[i])) {
					numberStack.push(applyOperation(operationStack.pop(),
							numberStack.pop(), numberStack.pop()));
				}
				operationStack.push(charToken[i]);
			}
		}

		while (!operationStack.isEmpty()) {
			numberStack.push(applyOperation(operationStack.pop(),
					numberStack.pop(), numberStack.pop()));
		}
		
		return numberStack.pop();

	}

	private static double applyOperation(char op, double b, double a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			return a / b;
		case '%':
			return a % b;
		case '^':
			return Math.pow(a, b);
		default:
			return 0;
		}
	}

	private static int precedence(Character op) {
		if (op == '+' || op == '-')
			return 1;
		else if (op == '*' || op == '/' || op == '%')
			return 2;
		else if (op == '^')
			return 3;
		return 0;
	}
}