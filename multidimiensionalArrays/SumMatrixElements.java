package javaAdvanced.multidimiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int totalSum = 0;

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
            for (int row = 0; row <matrix.length ; row++) {
                for (int col = 0; col <matrix[row].length ; col++) {
                    totalSum += matrix[row][col];
                }
            }

            // whit for each loop
//            for (int[] arr : matrix) {
//                for (int e : arr) {
//                    totalSum += e;
//                }
//            }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalSum);
    }
}

// in judge is the solution without matrix
