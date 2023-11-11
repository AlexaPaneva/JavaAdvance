package javaAdvanced.examPreparationE.matrix;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < size; row++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                territory[row][col] = singleRow[col];
                if (territory[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }
        }

//        for (int i = 0; i < size; i++) {
//            char[] singleRow = scanner.nextLine().toCharArray();
//            territory[i] = singleRow;
//
//        }
//
//        for (int row = 0; row < size; row++) {
//            for (int col = 0; col < size; col++) {
//                if (territory[row][col] == 'B') {
//                    beeRow = row;
//                    beeCol = col;
//                }
//            }
//        }
        int flowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            territory[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;
            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;
            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;
            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                territory[beeRow][beeCol] = '.';
                System.out.println("The bee got lost!");
                break;
            }

            if (territory[beeRow][beeCol] == 'f') {
                flowers++;
            } else if (territory[beeRow][beeCol] == 'O') {
                continue;
            }

            territory[beeRow][beeCol] = 'B';
            command = scanner.nextLine();
        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        printTerritory(size, territory, beeRow, beeCol);
    }

    private static void printTerritory(int size, char[][] territory, int beeRow, int beeCol) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }
}
