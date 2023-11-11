package javaAdvanced.setsAndMapsE;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        while (!"search".equals(command)) {
            String[] personData = command.split("-");
            String name = personData[0];
            String phone = personData[1];
            phonebook.put(name, phone);
//            phonebook.put(personData[0], personData[1]);


            command = scanner.nextLine();
        }
        command = scanner.nextLine();

        while (!command.equals("stop")) {
            if (phonebook.containsKey(command)) {
                System.out.printf("%s -> %s%n", command, phonebook.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command = scanner.nextLine();
        }
    }
}
