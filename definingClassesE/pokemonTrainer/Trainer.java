package javaAdvanced.definingClassesE.pokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void commandExecuting(String element) {
        if (isExist(element)) {
            numberOfBadges += 1;
        } else {
            for (int i = 0; i < collectionOfPokemon.size(); i++) {
                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                if (collectionOfPokemon.get(i).getHealth() <= 0) {
                    collectionOfPokemon.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isExist(String element) {
        for (Pokemon pokemon : collectionOfPokemon) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.collectionOfPokemon.size());

        // return name + " " + numberOfBadges + " " + collectionOfPokemon.size();
    }
}
