package javaAdvanced.stacksAndQ;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        String line = scanner.nextLine();
        String prevUrl = "no previous URLs";
        history.push(prevUrl);

        while (!line.equals("Home")) {

            if (line.equals("back")) {
                if (history.size() == 1) {
                    System.out.println(history.peek());
                } else {
                    prevUrl = history.pop();
                    System.out.println(prevUrl);
                }
            } else {
                if (!"no previous URLs".equals(prevUrl)) {
                    history.push(prevUrl);
                    forward.clear();
                }
                prevUrl = line;
                System.out.println(line);
            }

            line = scanner.nextLine();
        }
    }
}
