package javaAdvanced.regularExam;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int fishCaught = 0;
        int shipRow = -1;
        int shipCol = -1;


        for (int row = 0; row < size; row++) {
            String rowData = scanner.nextLine();
            matrix[row] = rowData.toCharArray();
            if (rowData.contains("S")) {
                shipRow = row;
                shipCol = rowData.indexOf("S");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("collect the nets")) {

            matrix[shipRow][shipCol] = '-';

            int newRow = shipRow;
            int newCol = shipCol;

            switch (command) {
                case "up":
                    if (newRow - 1 >= 0) {
                        newRow--;
                    } else {
                        matrix[newRow][newCol] = '-';
                        newRow = matrix.length - 1;
                    }
//                    newRow = (newRow - 1 + size) % size;
                    break;
                case "down":
                    if (newRow + 1 <= matrix.length - 1) {
                        newRow++;
                    } else {
                        matrix[newRow][newCol] = '-';
                        newRow = 0;
                    }
//                    newRow = (newRow + 1) % size;
                    break;
                case "left":
                    if (newCol - 1 >= 0) {
                        newCol--;
                    } else {
                        matrix[newRow][newCol] = '-';
                        newCol = matrix.length - 1;
                    }
                    //  newCol = (newCol - 1 + size) % size;
                    break;
                case "right":
                    if (newCol + 1 <= matrix.length - 1) {
                        newCol++;
                    } else {
                        matrix[newRow][newCol] = '-';
                        newCol = 0;
                    }
                    // newCol = (newCol + 1) % size;
                    break;
            }

            char newPosition = matrix[newRow][newCol];
            if (newPosition == '-') {
                matrix[shipRow][shipCol] = '-';
                shipRow = newRow;
                shipCol = newCol;
            } else if (Character.isDigit(newPosition)) {
                int fish = Character.getNumericValue(newPosition);
                fishCaught += fish;
                matrix[shipRow][shipCol] = '-';
                matrix[newRow][newCol] = 'S';
                shipRow = newRow;
                shipCol = newCol;
            }

            if (matrix[newRow][newCol] == 'W') {
                System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [" + newRow + "," + newCol + "]");
                return;
            }
            matrix[newRow][newCol] = 'S';

            command = scanner.nextLine();
        }


        if (fishCaught >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            int lackOfFish = 20 - fishCaught;
            System.out.print("You didn't catch enough fish and didn't reach the quota! ");
            System.out.printf("You need %d tons of fish more.%n", lackOfFish);
        }
        if (fishCaught > 0) {

            System.out.printf("Amount of fish caught: %d tons.%n", fishCaught);
        }

        printMatrix(matrix);
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }
}
