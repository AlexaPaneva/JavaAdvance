package javaAdvanced.examPreparationE.stackQueue;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstLootBoxQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstLootBoxQueue::offer);

        Deque<Integer> secondLootBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

//        List<Integer> loot = new ArrayList<>();


        int claimedItems = 0;
        while (!firstLootBoxQueue.isEmpty() && !secondLootBoxStack.isEmpty()) {

            int firstBox = firstLootBoxQueue.peek();
            int secondBox = secondLootBoxStack.peek();

            int sum = firstBox + secondBox;
            if (sum % 2 == 0) {
                claimedItems += sum;
//                loot.add(sum);
                firstLootBoxQueue.poll();
                secondLootBoxStack.pop();
            } else {
                secondLootBoxStack.pop();
                firstLootBoxQueue.offer(secondBox);
            }
        }
        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (claimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", claimedItems);
        }
    }
}
