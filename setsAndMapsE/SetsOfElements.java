package javaAdvanced.setsAndMapsE;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] setSizes = scanner.nextLine().split("\\s+");

        int firstSetSize = Integer.parseInt(setSizes[0]);
        int secondSetSize = Integer.parseInt(setSizes[1]);

        LinkedHashSet<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            String element = scanner.nextLine();
            firstSet.add(element);
        }
        LinkedHashSet<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < secondSetSize; i++) {
            String element = scanner.nextLine();
            secondSet.add(element);
        }
        firstSet.retainAll(secondSet);
        for (String e : firstSet) {
            System.out.print(e + " ");
        }
//        for (String e : firstSet) {
//            if (secondSet.contains(e)) {
//                System.out.print(e + " ");
//            }
//        }
    }
}
