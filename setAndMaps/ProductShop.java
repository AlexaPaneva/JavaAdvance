package javaAdvanced.setAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Double>> info = new TreeMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Revision")) {

            String[] input = command.split(", ");

            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            info.putIfAbsent(shop, new LinkedHashMap<>());
            LinkedHashMap<String, Double> innerInfo = info.get(shop);
            innerInfo.putIfAbsent(product, price);

            command = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Double>> entry : info.entrySet()) {
            System.out.println(entry.getKey() + "->");

            LinkedHashMap<String, Double> innerData = entry.getValue();

            for (var productData : innerData.entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", productData.getKey(), productData.getValue());
            }
        }


    }
}
