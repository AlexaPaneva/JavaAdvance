package javaAdvanced.definingClassesE.catLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Cat> catsMap = new LinkedHashMap<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String name = tokens[1];
            double catActions = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (catType) {
                case "Siamese":
                    cat = new Siamese(name, catType, catActions);
                    break;

                case "Cymric":
                    cat = new Cymric(name, catType, catActions);

                    break;

                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, catType, catActions);

                    break;
            }

            catsMap.put(name, cat);

            line = scanner.nextLine();
        }
        System.out.println(catsMap.get(scanner.nextLine()));
    }
}
