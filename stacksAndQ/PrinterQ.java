package javaAdvanced.stacksAndQ;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQ {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String files = scanner.nextLine();

        while (!files.equals("print")) {

            if (files.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    String canceledFiles = printerQueue.poll();
                    System.out.println("Canceled " + canceledFiles);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(files);
            }

            files = scanner.nextLine();
        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
