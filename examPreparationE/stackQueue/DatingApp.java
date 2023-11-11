package javaAdvanced.examPreparationE.stackQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(malesStack::push);

        Deque<Integer> femalesQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femalesQueue::offer);


        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueue.peek();

            if (male <= 0) {
                malesStack.pop();
                continue;
            } else if (female <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (female % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            } else if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }

            if (male == female) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                int decrease = malesStack.pop() - 2;
                malesStack.push(decrease);
            }
        }
        System.out.printf("Matches: %d\n", matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String resultForMales = malesStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Males left: " + resultForMales);
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String resultForFemales = femalesQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Females left: " + resultForFemales);
        }

    }
}
