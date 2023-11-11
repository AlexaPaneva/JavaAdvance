package javaAdvanced.stacksAndQ;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        ArrayDeque<String> expressions = new ArrayDeque<>();

        Collections.addAll(expressions, input);

        while (expressions.size() > 1) {
            int firstNumber = Integer.parseInt(expressions.pop());
            String operator = expressions.pop();
            int secondNumber = Integer.parseInt(expressions.pop());

            int result = 0;
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (operator.equals("-")) {
                result = firstNumber - secondNumber;
            }
            expressions.push(String.valueOf(result));
        }
        System.out.println(expressions.peek());
    }
}
