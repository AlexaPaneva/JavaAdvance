package javaAdvanced.multidimensionalArraysE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] rotation = scanner.nextLine().split("[()]");
        int rotationNumber = Integer.parseInt(rotation[1]);
        int angleOfRotation = rotationNumber % 360;

        String words = scanner.nextLine();

        List<String> list = new ArrayList<>();
        int maxLength = Integer.MIN_VALUE;
        while (!words.equals("END")) {
            list.add(words);

            if (words.length() > maxLength) {
                maxLength = words.length();
            }

            words = scanner.nextLine();
        }

        int rows = list.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String currentWord = list.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        //From top to bottom -> row++
        //From bottom to top -> row--
        //From left to right -> col++
        //From right to left -> col--

        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;

        }
    }
}
