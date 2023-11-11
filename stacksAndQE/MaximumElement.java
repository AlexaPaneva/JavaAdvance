package javaAdvanced.stacksAndQE;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

            for (int count = 1; count <= n; count++) {

/*
                String[] command = scanner.nextLine().split("\\s+");

                switch (command[0]) {
                    case "1":
                        stack.push(Integer.parseInt(command[1]));
                        break;

                    case "2":
                        stack.pop();
                        break;

                    case "3":
                        System.out.println(Collections.max(stack));
                        break;
                }
*/


                String command = scanner.nextLine();
                //"1 X" -> push x to stack
                //"2" -> pop of stack
                //"3" -> print max element only if stack is not empty
                if (command.equals("2")) {
                    stack.pop();
                } else if (command.equals("3")) {
                    //проверка дали имаме елементи
                    if (stack.size() > 0) {
                        System.out.println(Collections.max(stack));
                    }
                } else {
                    //command = "1 97" .split -> ["1", "97"]
                    int x = Integer.parseInt(command.split("\\s+")[1]);
                    stack.push(x);
                }
            }
    }
}
