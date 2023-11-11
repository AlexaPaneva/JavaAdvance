package javaAdvanced.regularExam;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()); //размер на матрицата: бр. редове = бр. колоните = size

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int shipRow = -1;
        int shipCol = -1;
        int fishCaught = 0;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    shipRow = row;
                    shipCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("collect the nets")) {

            int startRow = shipRow;
            int startCol = shipCol;
            switch (command) {
                case "up":
                    if (shipRow - 1 >= 0) {
                        shipRow--;
                    } else {
                        matrix[shipRow][shipCol] = "-";
                        shipRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    if (shipRow + 1 <= matrix.length - 1) {
                        shipRow++;
                    } else {
                        matrix[shipRow][shipCol] = "-";
                        shipRow = 0;
                    }
                    break;
                case "left":
                    if (shipCol - 1 >= 0) {
                        shipCol--;
                    } else {
                        matrix[shipRow][shipCol] = "-";
                        shipCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    if (shipCol + 1 <= matrix.length - 1) {
                        shipCol++;
                    } else {
                        matrix[shipRow][shipCol] = "-";
                        shipCol = 0;
                    }
                    break;
            }
            if (matrix[shipRow][shipCol].matches("[0-9]")) {
                int fishValue = Integer.parseInt(matrix[shipRow][shipCol]);
                fishCaught += fishValue;
                matrix[shipRow][shipCol] = "-";
            }

            command = scanner.nextLine();
        }
        if (matrix[shipRow][shipCol].equals("W")) {
            System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: " + matrix[shipRow][shipCol]);
        }
        if (fishCaught >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            int lackOfFish = 20 - fishCaught;
            System.out.println("You didn't catch enough fish and didn't reach the quota!");
            System.out.println("You need " + lackOfFish + " tons of fish more.");
        }

        System.out.println("Amount of fish caught: " + fishCaught + " tons.");
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            System.out.println(String.join("", row));
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
