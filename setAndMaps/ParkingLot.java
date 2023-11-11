package javaAdvanced.setAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();


        String input = scanner.nextLine();
        while (!input.equals("END")) { //!"END".equals(input)

            String[] command = input.split(", ");
            String direction = command[0];
            String carNumber = command[1];

           if (direction.equals("IN")) {
               parkingLot.add(carNumber);
           } else {
               parkingLot.remove(carNumber);
           }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }

    }
}
