package javaAdvanced.streamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "JavaAdvanced\\StreamsFilesAndDirectories\\input.txt";


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        String line = reader.readLine();

        int counter = 1;

        List<String> lines = new ArrayList<>();

        while (line != null) {
            if (counter % 3 == 0) {
                lines.add(line);
            }
            counter++;
            line = reader.readLine();
        }

        Path pathObj = Paths.get("javaAdvanced/streamsFilesAndDirectories/write-every-third-line-output.txt");

        Files.write(pathObj, lines);
    }
}
