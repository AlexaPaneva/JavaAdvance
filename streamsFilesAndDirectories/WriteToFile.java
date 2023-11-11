package javaAdvanced.streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String path = "JavaAdvanced\\StreamsFilesAndDirectories\\input.txt";

        Set<Character> punctuations = Set.of(',', '.', '!', '?');

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("javaAdvanced/streamsFilesAndDirectories/write-to-file-output-txt");


        int oneByte = inputStream.read();

        while (oneByte >= 0) {

            char symbol = (char) oneByte;

            if (!punctuations.contains(symbol)) {
                System.out.print(symbol); //outputStream.write(symbol);
            }

            oneByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
