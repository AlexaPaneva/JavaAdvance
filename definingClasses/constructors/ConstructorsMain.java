package javaAdvanced.definingClasses.constructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConstructorsMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Constructors> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];

            Constructors car;
            if (tokens.length == 1) {
                car = new Constructors(brand);
            } else {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                car = new Constructors(brand, model, horsePower);
            }

            cars.add(car);
        }

        cars.forEach(System.out::println);
    }
}
