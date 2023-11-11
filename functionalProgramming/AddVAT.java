package javaAdvanced.functionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVAT {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        Function<String, Double> parsePriceAddingVAT = s -> Double.parseDouble(s) * 1.2;

        Arrays.stream(scanner.nextLine().split(", "))
                .map(parsePriceAddingVAT)
                .forEach(v -> System.out.printf("%.2f%n", v));

        /*
        UnaryOperator<String> priceWithVAT =
                        s -> String.format("%.2f", Double.parseDouble(s) * 1.2);

                Arrays.stream(scanner.nextLine().split(", "))
                        .map(priceWithVAT)
                        .forEach(System.out::println);
        */
    }
}
