package javaAdvanced.streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\User\\Desktop\\SoftUni\\src" +
                "\\JavaAdvanced\\StreamsFilesAndDirectories\\input.txt";

        try (FileInputStream inputStream = new FileInputStream(path)) {
            int oneByte = inputStream.read();

            while (oneByte > 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println("File with path" + path + "was not found!");
        }
    }
}
