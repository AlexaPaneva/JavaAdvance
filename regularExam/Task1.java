package javaAdvanced.regularExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> currentfuelStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(currentfuelStack::push);

        Deque<Integer> consumptionIndexesQueue  = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(consumptionIndexesQueue ::offer);

        Deque<Integer> quantitiesQueue  = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(quantitiesQueue::offer);

        int currentAltitude = 0;
        boolean reachedTop = true;

        while (!quantitiesQueue.isEmpty()) {
            int currentFuel = currentfuelStack.peek();
            int consumptionIndex = consumptionIndexesQueue.peek();
            int requiredFuel = quantitiesQueue.peek();

            if (currentFuel - consumptionIndex >= requiredFuel) {
                currentfuelStack.pop();
                consumptionIndexesQueue.poll();
                quantitiesQueue.poll();
                currentAltitude++;
                System.out.println("John has reached: Altitude " + currentAltitude);
            } else {
                reachedTop = false;
                System.out.println("John did not reach: Altitude " + (currentAltitude + 1));
                break;
            }
        }

        if (reachedTop) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else if (currentAltitude > 0) {
            System.out.println("John failed to reach the top.");
            System.out.print("Reached altitudes: Altitude 1");
            for (int i = 2; i <= currentAltitude; i++) {
                System.out.print(", Altitude " + i);
            }
            System.out.println();
        } else {
            System.out.println("John failed to reach the top.");
            System.out.println("John didn't reach any altitude.");
        }
    }
}
