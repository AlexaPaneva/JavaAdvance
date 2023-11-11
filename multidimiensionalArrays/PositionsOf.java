package javaAdvanced.multidimiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArr(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];


        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            int[] arr = readArr(scanner);

            for (int c = 0; c < cols; c++) {
                matrix[r][c] = arr[c];
            }
        }
        boolean isFound = false;

        int specialValue = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentElement = matrix[row][col];
                if (currentElement == specialValue) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static int[] readArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
