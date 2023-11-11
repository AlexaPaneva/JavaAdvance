package javaAdvanced.regularExam;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] fishingArea = new char[n][n];

        int fishCaught = 0;
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            fishingArea[i] = row.toCharArray();
            if (row.contains("S")) {
                playerRow = i;
                playerCol = row.indexOf("S");
            }
            if (row.contains("F")) {
                fishCaught += row.chars().filter(ch -> ch == 'F').count();
            }
        }

        int quota = 20;
        boolean quotaReached = fishCaught >= quota;

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("collect the nets")) {
                break;
            }

            int newRow = playerRow;
            int newCol = playerCol;

            switch (command) {
                case "up":
                    newRow = (newRow - 1 + n) % n;
                    break;
                case "down":
                    newRow = (newRow + 1) % n;
                    break;
                case "left":
                    newCol = (newCol - 1 + n) % n;
                    break;
                case "right":
                    newCol = (newCol + 1) % n;
                    break;
            }


            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) {
                newRow = Math.abs(newRow - n) % n;
                newCol = Math.abs(newCol - n) % n;
            }

            if (fishingArea[newRow][newCol] == 'W') {
                System.out.println("You fell into a whirlpool! The ship sank and you lost the fish you caught. " +
                        "Last coordinates of the ship: [" + newRow + "," + newCol + "]");
                return;
            }

            if (Character.isDigit(fishingArea[newRow][newCol])) {
                int fishValue = Character.getNumericValue(fishingArea[newRow][newCol]);
                fishCaught += fishValue;
                fishingArea[newRow][newCol] = '-';
            }

            playerRow = newRow;
            playerCol = newCol;

            quotaReached = fishCaught >= quota;

            if (quotaReached) {
                System.out.println("Success! You managed to reach the quota!");
                System.out.println("Amount of fish caught: " + fishCaught + " tons.");
                break;
            }
        }

        if (!quotaReached) {
            int lackOfFish = quota - fishCaught;
            System.out.println("You didn't catch enough fish and didn't reach the quota!\n" +
                    "You need " + lackOfFish + " tons of fish more.");
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(fishingArea[i][j]);
            }
            System.out.println();
        }
    }
}