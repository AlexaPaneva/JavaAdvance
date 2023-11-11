package javaAdvanced.definingClassesE.pokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, List<Pokemon>> pokemonMap = new LinkedHashMap<>();


        String line = scanner.nextLine();
        while (!line.equals("Tournament")) {
            String[] pokemonData = line.split("\\s+");
            String trainerName = pokemonData[0];
            String pokemonName = pokemonData[1];
            String pokemonElement = pokemonData[2];
            int pokemonHealth = Integer.parseInt(pokemonData[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            pokemonMap.putIfAbsent(trainerName, new ArrayList<>());
            pokemonMap.get(trainerName).add(pokemon);

            line = scanner.nextLine();
        }

        List<Trainer> trainerList = pokemonMap.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());

        String element = scanner.nextLine();
        while (!element.equals("End")) {
            for (Trainer trainer : trainerList) {
                trainer.commandExecuting(element);
            }

            element = scanner.nextLine();
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getNumberOfBadges).reversed())
                .forEach(System.out::println);
    }
}
