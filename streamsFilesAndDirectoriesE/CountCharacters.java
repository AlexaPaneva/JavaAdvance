package javaAdvanced.streamsFilesAndDirectoriesE;

import java.io.FileReader;
import java.io.IOException;

public class CountCharacters {
    public static void main(String[] args) throws IOException {
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        FileReader fr = new FileReader("javaAdvanced/streamsFilesAndDirectoriesE/input.txt");
        int oneByte = fr.read();
        while (oneByte >= 0) {
            char symbol = convertToLowerCaseChar(oneByte);

            if (isVowel(symbol)) {
                vowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                consonants++;
            }
            oneByte = fr.read();
        }
        fr.close();
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Punctuation: " + punctuation);

    }

    private static char convertToLowerCaseChar(int oneByte) {
        char symbol = (char) oneByte;

        String text = symbol + "";
        text = text.toLowerCase();
        return text.charAt(0);
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '.' || symbol == ',' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';


    }
}
