package javaAdvanced.stacksAndQE;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ReversedNumbersWithStack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

/*
        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            int element = Integer.parseInt(input[i]);
            stack.push(element);
        }
*/

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(stack::push);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
