package javaAdvanced.multidimiensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        if (areEqual) {

            for (int r = 0; r < firstMatrix.length; r++) {


                int[] firstArr = firstMatrix[r];
                int[] secondArr = secondMatrix[r];

                areEqual = firstArr.length == secondArr.length;

                if (areEqual) {
                    for (int i = 0; i < firstArr.length; i++) {
                        if (firstArr[i] != secondArr[i]) {
                            areEqual = false;
                        }
                    }
                }
            }
        }

        String output;
        if (areEqual) {
            output = "equal";
        } else {
            output = "not equal";
        }
        System.out.println(output);
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] MatrixSize = readArray(scanner);

        int rows = MatrixSize[0];
        int cols = MatrixSize[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = readArray(scanner);

            matrix[i] = arr;
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
