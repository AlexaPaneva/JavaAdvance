package javaAdvanced.setAndMaps;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 50;

        while (round-- > 0) {
            int firstCard = firstDeck.iterator().next();
            //==
//            for (Integer c : firstDeck) {
//                firstCard = c;
//                break;

            int secondCard = secondDeck.iterator().next();
            //==
//            for (Integer c : secondDeck) {
//                secondCard = c;
//                break;
//            }

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }

        String output;
        if (firstDeck.size() > secondDeck.size()) {
            output = "First player win!";
        } else if (secondDeck.size() > firstDeck.size()) {
            output = "Second player win!";
        } else {
            output = "Draw!";
        }
        System.out.println(output);
    }
}
