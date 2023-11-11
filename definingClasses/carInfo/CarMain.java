package javaAdvanced.definingClasses.carInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<CarInfo> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String brand = tokens[0];
            String model = tokens[1];

            int horsePower = Integer.parseInt(tokens[2]);

            CarInfo car = new CarInfo();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);

        }
        cars.forEach(System.out::println);
    }
}
