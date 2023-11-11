package javaAdvanced.streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        String path = "JavaAdvanced\\StreamsFilesAndDirectories\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        FileOutputStream outputStream = new FileOutputStream("javaAdvanced/streamsFilesAndDirectories/copy-bytes-output.txt");

        int oneByte = inputStream.read();

        while (oneByte != -1) {

            if (oneByte == 32) {
                outputStream.write(' ');
            } else if (oneByte == 10) {
                outputStream.write('\n');
            } else {

                String message = String.valueOf(oneByte);

                for (char c : message.toCharArray()) {
                    outputStream.write(c);
                }

            }

            oneByte = inputStream.read();
        }

    }
}
