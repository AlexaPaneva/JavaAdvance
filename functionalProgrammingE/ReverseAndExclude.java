package javaAdvanced.functionalProgrammingE;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);
        list.removeIf(number -> number % n == 0);

//        Predicate<Integer> predicate = number -> number % n == 0;
//        list.removeIf(predicate);

        list.forEach(e -> System.out.print(e + " "));
    }
}
