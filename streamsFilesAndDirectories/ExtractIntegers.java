package javaAdvanced.streamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "JavaAdvanced\\StreamsFilesAndDirectories\\input.txt";
//        Scanner scanner = new Scanner(System.in);
        //=
        Scanner scanner = new Scanner(new FileInputStream(path));


//        FileInputStream inputStream = new FileInputStream(path);

        //   FileOutputStream outputStream = new FileOutputStream("");

        //   int oneByte = inputStream.read();

        //   PrintWriter printer = new PrintWriter(new FileOutputStream("extract-integers-output.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.next());
                //   printer.println(scanner.next());
            }
            scanner.next();
        }
        //printer.close
    }
}
