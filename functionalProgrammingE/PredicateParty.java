package javaAdvanced.functionalProgrammingE;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Predicate<String> predicate;

        List<String> guestsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("Party!")) {

            String criteria = line.split("\\s+")[2];

            if (line.contains("StartsWith")) {
                predicate = s -> s.startsWith(criteria);
            } else if (line.contains("EndsWith")) {
                predicate = s -> s.endsWith(criteria);
            } else {
                predicate = s -> s.length() == Integer.parseInt(criteria);
            }

            if (line.contains("Remove")) {
                guestsList.removeIf(predicate);
            } else {
                List<String> guestsToDouble = guestsList.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guestsList.addAll(guestsToDouble);
            }

            line = scanner.nextLine();
        }

        if (guestsList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String result = guestsList.stream()
                    .sorted()
                    .collect(Collectors.joining(", ")) + " are going to the party!";

            System.out.println(result);
        }
    }
}





