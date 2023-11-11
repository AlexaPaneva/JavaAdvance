package javaAdvanced.setsAndMapsE;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] compound = scanner.nextLine().split("\\s+");
            for (String element : compound) {
                elements.add(element);
            }
        }
//        for (String element : elements) {
//            System.out.println(element + " ");
//        }
        String result = String.join(" ", elements);
        System.out.println(result);
    }
}
